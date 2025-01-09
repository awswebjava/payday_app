package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.escalasalarialview", "/web.escalasalarialview"})
public final  class escalasalarialview extends GXWebObjectStub
{
   public escalasalarialview( )
   {
   }

   public escalasalarialview( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( escalasalarialview.class ));
   }

   public escalasalarialview( int remoteHandle ,
                              ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new escalasalarialview_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new escalasalarialview_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Escala Salarial View";
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

