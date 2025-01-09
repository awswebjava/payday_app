package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.templatereciboview", "/web.templatereciboview"})
public final  class templatereciboview extends GXWebObjectStub
{
   public templatereciboview( )
   {
   }

   public templatereciboview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( templatereciboview.class ));
   }

   public templatereciboview( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new templatereciboview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new templatereciboview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Template Recibo View";
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

