package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.registronucleo", "/web.registronucleo"})
public final  class registronucleo extends GXWebObjectStub
{
   public registronucleo( )
   {
   }

   public registronucleo( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( registronucleo.class ));
   }

   public registronucleo( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new registronucleo_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new registronucleo_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Registro núcleo";
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

