package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.parentescoview", "/web.parentescoview"})
public final  class parentescoview extends GXWebObjectStub
{
   public parentescoview( )
   {
   }

   public parentescoview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( parentescoview.class ));
   }

   public parentescoview( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new parentescoview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new parentescoview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Parentesco View";
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

