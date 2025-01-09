package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.clientecct_fondoceseview", "/web.clientecct_fondoceseview"})
public final  class clientecct_fondoceseview extends GXWebObjectStub
{
   public clientecct_fondoceseview( )
   {
   }

   public clientecct_fondoceseview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clientecct_fondoceseview.class ));
   }

   public clientecct_fondoceseview( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clientecct_fondoceseview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clientecct_fondoceseview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Clientecct_fondocese View";
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

