package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipo_feriadoww", "/web.tipo_feriadoww"})
public final  class tipo_feriadoww extends GXWebObjectStub
{
   public tipo_feriadoww( )
   {
   }

   public tipo_feriadoww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipo_feriadoww.class ));
   }

   public tipo_feriadoww( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipo_feriadoww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipo_feriadoww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " tipo_feriado";
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

