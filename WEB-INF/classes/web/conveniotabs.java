package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conveniotabs", "/web.conveniotabs"})
public final  class conveniotabs extends GXWebObjectStub
{
   public conveniotabs( )
   {
   }

   public conveniotabs( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conveniotabs.class ));
   }

   public conveniotabs( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conveniotabs_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conveniotabs_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Convenio Tabs";
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

