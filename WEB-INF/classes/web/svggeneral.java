package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.svggeneral", "/web.svggeneral"})
public final  class svggeneral extends GXWebObjectStub
{
   public svggeneral( )
   {
   }

   public svggeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( svggeneral.class ));
   }

   public svggeneral( int remoteHandle ,
                      ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new svggeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new svggeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "SVGGeneral";
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

