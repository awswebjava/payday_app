package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.esquemahorasextrasww", "/web.esquemahorasextrasww"})
public final  class esquemahorasextrasww extends GXWebObjectStub
{
   public esquemahorasextrasww( )
   {
   }

   public esquemahorasextrasww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( esquemahorasextrasww.class ));
   }

   public esquemahorasextrasww( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new esquemahorasextrasww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new esquemahorasextrasww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Esquema Horas Extras";
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

