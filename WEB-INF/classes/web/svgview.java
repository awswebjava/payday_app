package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.svgview", "/web.svgview"})
public final  class svgview extends GXWebObjectStub
{
   public svgview( )
   {
   }

   public svgview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( svgview.class ));
   }

   public svgview( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new svgview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new svgview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "SVGView";
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

