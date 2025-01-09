package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.tipoliquidacion", "/web.tipoliquidacion"})
public final  class tipoliquidacion extends GXWebObjectStub
{
   public tipoliquidacion( )
   {
   }

   public tipoliquidacion( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( tipoliquidacion.class ));
   }

   public tipoliquidacion( int remoteHandle ,
                           ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new tipoliquidacion_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new tipoliquidacion_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Tipo Liquidacion";
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
      return "tipoliquidacion_Execute";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

}

