package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.clientecct_fondoceseww", "/web.clientecct_fondoceseww"})
public final  class clientecct_fondoceseww extends GXWebObjectStub
{
   public clientecct_fondoceseww( )
   {
   }

   public clientecct_fondoceseww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( clientecct_fondoceseww.class ));
   }

   public clientecct_fondoceseww( int remoteHandle ,
                                  ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new clientecct_fondoceseww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new clientecct_fondoceseww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Convenio Fondo de cese laboral";
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

