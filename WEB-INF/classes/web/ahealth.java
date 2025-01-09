package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.ahealth", "/web.ahealth"})
public final  class ahealth extends GXWebObjectStub
{
   public ahealth( )
   {
   }

   public ahealth( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( ahealth.class ));
   }

   public ahealth( int remoteHandle ,
                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new ahealth_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new ahealth_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "health";
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

