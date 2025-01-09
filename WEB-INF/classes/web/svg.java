package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.svg", "/web.svg"})
public final  class svg extends GXWebObjectStub
{
   public svg( )
   {
   }

   public svg( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( svg.class ));
   }

   public svg( int remoteHandle ,
               ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new svg_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new svg_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "SVG";
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

