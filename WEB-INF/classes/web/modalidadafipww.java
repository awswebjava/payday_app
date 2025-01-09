package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.modalidadafipww", "/web.modalidadafipww"})
public final  class modalidadafipww extends GXWebObjectStub
{
   public modalidadafipww( )
   {
   }

   public modalidadafipww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( modalidadafipww.class ));
   }

   public modalidadafipww( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new modalidadafipww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new modalidadafipww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Modalidad";
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

