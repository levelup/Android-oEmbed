package co.tophe.oembed;

import co.tophe.ServerException;
import co.tophe.TypedHttpRequest;

/**
 * A TOPHE HTTP request that returns an {@link co.tophe.oembed.OEmbed} object.
 */
public interface OEmbedRequest extends TypedHttpRequest<OEmbed,ServerException> {
}
