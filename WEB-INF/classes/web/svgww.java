package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.svgww", "/web.svgww"})
public final  class svgww extends GXWebObjectStub
{
   public svgww( )
   {
   }

   public svgww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( svgww.class ));
   }

   public svgww( int remoteHandle ,
                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new svgww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new svgww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " SVG";
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

