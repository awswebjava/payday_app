package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.esquemahorasespecialesww", "/web.esquemahorasespecialesww"})
public final  class esquemahorasespecialesww extends GXWebObjectStub
{
   public esquemahorasespecialesww( )
   {
   }

   public esquemahorasespecialesww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( esquemahorasespecialesww.class ));
   }

   public esquemahorasespecialesww( int remoteHandle ,
                                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new esquemahorasespecialesww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new esquemahorasespecialesww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Esquema Horas Especiales";
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

