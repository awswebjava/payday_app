package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.afipconceptoww", "/web.afipconceptoww"})
public final  class afipconceptoww extends GXWebObjectStub
{
   public afipconceptoww( )
   {
   }

   public afipconceptoww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( afipconceptoww.class ));
   }

   public afipconceptoww( int remoteHandle ,
                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new afipconceptoww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new afipconceptoww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Conceptos AFIP";
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

