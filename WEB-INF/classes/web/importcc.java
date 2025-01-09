package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.importcc", "/web.importcc"})
public final  class importcc extends GXWebObjectStub
{
   public importcc( )
   {
   }

   public importcc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( importcc.class ));
   }

   public importcc( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new importcc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new importcc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " importacion_conceptos";
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

