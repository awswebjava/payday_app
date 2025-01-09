package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.escalasalarialww", "/web.escalasalarialww"})
public final  class escalasalarialww extends GXWebObjectStub
{
   public escalasalarialww( )
   {
   }

   public escalasalarialww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( escalasalarialww.class ));
   }

   public escalasalarialww( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new escalasalarialww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new escalasalarialww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Escala Salarial";
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

