package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.formulawc", "/web.formulawc"})
public final  class formulawc extends GXWebObjectStub
{
   public formulawc( )
   {
   }

   public formulawc( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( formulawc.class ));
   }

   public formulawc( int remoteHandle ,
                     ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new formulawc_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new formulawc_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Editar Fórmula";
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

