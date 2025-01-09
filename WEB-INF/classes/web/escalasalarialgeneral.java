package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.escalasalarialgeneral", "/web.escalasalarialgeneral"})
public final  class escalasalarialgeneral extends GXWebObjectStub
{
   public escalasalarialgeneral( )
   {
   }

   public escalasalarialgeneral( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( escalasalarialgeneral.class ));
   }

   public escalasalarialgeneral( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new escalasalarialgeneral_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new escalasalarialgeneral_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Escala Salarial General";
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

