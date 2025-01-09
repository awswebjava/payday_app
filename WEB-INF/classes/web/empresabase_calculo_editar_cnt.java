package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.empresabase_calculo_editar_cnt", "/web.empresabase_calculo_editar_cnt"})
public final  class empresabase_calculo_editar_cnt extends GXWebObjectStub
{
   public empresabase_calculo_editar_cnt( )
   {
   }

   public empresabase_calculo_editar_cnt( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( empresabase_calculo_editar_cnt.class ));
   }

   public empresabase_calculo_editar_cnt( int remoteHandle ,
                                          ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new empresabase_calculo_editar_cnt_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new empresabase_calculo_editar_cnt_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Empresabase_calculo_editar_cnt";
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

