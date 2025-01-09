package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.webpanel5", "/web.webpanel5"})
public final  class webpanel5 extends GXWebObjectStub
{
   public webpanel5( )
   {
   }

   public webpanel5( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( webpanel5.class ));
   }

   public webpanel5( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new webpanel5_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new webpanel5_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Web Panel5";
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

