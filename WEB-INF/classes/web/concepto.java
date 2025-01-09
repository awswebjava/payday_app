package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.concepto", "/web.concepto"})
public final  class concepto extends GXWebObjectStub
{
   public concepto( )
   {
   }

   public concepto( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( concepto.class ));
   }

   public concepto( int remoteHandle ,
                    ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new concepto_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new concepto_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Concepto";
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
      return "concepto_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

