package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.conceptotipoliquidacion", "/web.conceptotipoliquidacion"})
public final  class conceptotipoliquidacion extends GXWebObjectStub
{
   public conceptotipoliquidacion( )
   {
   }

   public conceptotipoliquidacion( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( conceptotipoliquidacion.class ));
   }

   public conceptotipoliquidacion( int remoteHandle ,
                                   ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new conceptotipoliquidacion_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new conceptotipoliquidacion_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Concepto Tipo Liquidacion";
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

