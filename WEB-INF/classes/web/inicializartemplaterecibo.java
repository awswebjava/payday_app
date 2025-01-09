package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inicializartemplaterecibo extends GXProcedure
{
   public inicializartemplaterecibo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inicializartemplaterecibo.class ), "" );
   }

   public inicializartemplaterecibo( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             short aP1 )
   {
      inicializartemplaterecibo.this.AV15CliCod = aP0;
      inicializartemplaterecibo.this.AV13EmpCod = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_int1[0] = AV28PaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV15CliCod, GXv_int1) ;
      inicializartemplaterecibo.this.AV28PaiCod = GXv_int1[0] ;
      GXv_int2[0] = AV14sistemaCliCod ;
      new web.clientenucleodepais(remoteHandle, context).execute( AV28PaiCod, GXv_int2) ;
      inicializartemplaterecibo.this.AV14sistemaCliCod = GXv_int2[0] ;
      if ( AV15CliCod == AV14sistemaCliCod )
      {
         GXv_char3[0] = AV12rutaAplicacion ;
         new web.getdefaultpath(remoteHandle, context).execute( GXv_char3) ;
         inicializartemplaterecibo.this.AV12rutaAplicacion = GXv_char3[0] ;
         AV24i = (short)(1) ;
         while ( AV24i <= 2 )
         {
            if ( AV24i == 1 )
            {
               AV23TempRecDescrip = httpContext.getMessage( "Template Recibo Apaisado", "") ;
               AV22ruta = AV12rutaAplicacion + httpContext.getMessage( "/templates/TemplateReciboApaisado.html", "") ;
            }
            else
            {
               AV23TempRecDescrip = httpContext.getMessage( "Template Recibo Vertical", "") ;
               AV22ruta = AV12rutaAplicacion + httpContext.getMessage( "/templates/TemplateReciboRetrato.html", "") ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "!ruta ", "")+GXutil.trim( AV22ruta)) ;
            AV8File.setSource( GXutil.trim( AV22ruta) );
            AV18TempRecHTML = "" ;
            if ( AV8File.exists() )
            {
               AV8File.openRead("");
               while ( ! AV8File.getEof() )
               {
                  AV18TempRecHTML += AV8File.readLine() ;
               }
               AV8File.close();
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "No encuentra archivo ", "")+GXutil.trim( AV22ruta)) ;
            }
            AV22ruta = AV12rutaAplicacion + httpContext.getMessage( "/templates/TemplateReciboApaisadoRow.html", "") ;
            AV8File.setSource( GXutil.trim( AV22ruta) );
            AV17TempRecHTMLRow = "" ;
            if ( AV8File.exists() )
            {
               AV8File.openRead("");
               while ( ! AV8File.getEof() )
               {
                  AV17TempRecHTMLRow += AV8File.readLine() ;
               }
               AV8File.close();
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "No encuentra archivo ", "")+GXutil.trim( AV22ruta)) ;
            }
            if ( AV24i == 1 )
            {
               AV22ruta = AV12rutaAplicacion + httpContext.getMessage( "/templates/TemplateReciboApaisadoBody.html", "") ;
            }
            else
            {
               AV22ruta = AV12rutaAplicacion + httpContext.getMessage( "/templates/TemplateReciboRetratoBody.html", "") ;
            }
            AV8File.setSource( GXutil.trim( AV22ruta) );
            AV21TempRecHTMLBody = "" ;
            if ( AV8File.exists() )
            {
               AV8File.openRead("");
               while ( ! AV8File.getEof() )
               {
                  AV21TempRecHTMLBody += AV8File.readLine() ;
               }
               AV8File.close();
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "No encuentra archivo ", "")+GXutil.trim( AV22ruta)) ;
            }
            AV22ruta = AV12rutaAplicacion + httpContext.getMessage( "/templates/explicaGanancias.html", "") ;
            AV8File.setSource( GXutil.trim( AV22ruta) );
            AV27TempRecExplIIGG = "" ;
            if ( AV8File.exists() )
            {
               AV8File.openRead("");
               while ( ! AV8File.getEof() )
               {
                  AV27TempRecExplIIGG += AV8File.readLine() ;
               }
               AV8File.close();
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV31Pgmname, httpContext.getMessage( "No encuentra archivo ", "")+GXutil.trim( AV22ruta)) ;
            }
            if ( AV24i == 1 )
            {
               AV19TempRecTipoRecibo = "Apaisado" ;
               AV20TempRecPageSize = (short)(22) ;
            }
            else
            {
               AV19TempRecTipoRecibo = "Vertical" ;
               AV20TempRecPageSize = (short)(24) ;
            }
            AV26TempRecRuta = GXutil.trim( AV22ruta) ;
            /* Execute user subroutine: 'NEW TEMPLATE' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV24i = (short)(AV24i+1) ;
         }
      }
      else
      {
         /* Using cursor P00KL2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV14sistemaCliCod)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A3CliCod = P00KL2_A3CliCod[0] ;
            A572TempRecHTML = P00KL2_A572TempRecHTML[0] ;
            A573TempRecHTMLRow = P00KL2_A573TempRecHTMLRow[0] ;
            A574TempRecTipoRecibo = P00KL2_A574TempRecTipoRecibo[0] ;
            A575TempRecPageSize = P00KL2_A575TempRecPageSize[0] ;
            A576TempRecHTMLBody = P00KL2_A576TempRecHTMLBody[0] ;
            A571TempRecDescrip = P00KL2_A571TempRecDescrip[0] ;
            A86TempRecSec = P00KL2_A86TempRecSec[0] ;
            A1139TempRecExplIIGG = P00KL2_A1139TempRecExplIIGG[0] ;
            A1EmpCod = P00KL2_A1EmpCod[0] ;
            AV18TempRecHTML = A572TempRecHTML ;
            AV17TempRecHTMLRow = A573TempRecHTMLRow ;
            AV19TempRecTipoRecibo = A574TempRecTipoRecibo ;
            AV20TempRecPageSize = A575TempRecPageSize ;
            AV21TempRecHTMLBody = A576TempRecHTMLBody ;
            AV23TempRecDescrip = A571TempRecDescrip ;
            AV26TempRecRuta = httpContext.getMessage( "Clicod ", "") + GXutil.trim( GXutil.str( A3CliCod, 6, 0)) + httpContext.getMessage( " TempRecSec ", "") + GXutil.trim( GXutil.str( A86TempRecSec, 4, 0)) ;
            AV27TempRecExplIIGG = A1139TempRecExplIIGG ;
            /* Execute user subroutine: 'NEW TEMPLATE' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'NEW TEMPLATE' Routine */
      returnInSub = false ;
      AV25TempRecSec = (short)(AV25TempRecSec+1) ;
      /*
         INSERT RECORD ON TABLE TemplateRecibo

      */
      A3CliCod = AV15CliCod ;
      A1EmpCod = AV13EmpCod ;
      A86TempRecSec = AV25TempRecSec ;
      A571TempRecDescrip = AV23TempRecDescrip ;
      A572TempRecHTML = AV18TempRecHTML ;
      A573TempRecHTMLRow = AV17TempRecHTMLRow ;
      A574TempRecTipoRecibo = AV19TempRecTipoRecibo ;
      A575TempRecPageSize = AV20TempRecPageSize ;
      A576TempRecHTMLBody = AV21TempRecHTMLBody ;
      A949TempRecRuta = AV26TempRecRuta ;
      A1139TempRecExplIIGG = AV27TempRecExplIIGG ;
      A972TempRecCss = "" ;
      /* Using cursor P00KL3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A86TempRecSec), A571TempRecDescrip, A572TempRecHTML, A576TempRecHTMLBody, A573TempRecHTMLRow, A574TempRecTipoRecibo, Short.valueOf(A575TempRecPageSize), A949TempRecRuta, A972TempRecCss, A1139TempRecExplIIGG});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TemplateRecibo");
      if ( (pr_default.getStatus(1) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "inicializartemplaterecibo");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int1 = new short[1] ;
      GXv_int2 = new int[1] ;
      AV12rutaAplicacion = "" ;
      GXv_char3 = new String[1] ;
      AV23TempRecDescrip = "" ;
      AV22ruta = "" ;
      AV31Pgmname = "" ;
      AV8File = new com.genexus.util.GXFile();
      AV18TempRecHTML = "" ;
      AV17TempRecHTMLRow = "" ;
      AV21TempRecHTMLBody = "" ;
      AV27TempRecExplIIGG = "" ;
      AV19TempRecTipoRecibo = "" ;
      AV26TempRecRuta = "" ;
      scmdbuf = "" ;
      P00KL2_A3CliCod = new int[1] ;
      P00KL2_A572TempRecHTML = new String[] {""} ;
      P00KL2_A573TempRecHTMLRow = new String[] {""} ;
      P00KL2_A574TempRecTipoRecibo = new String[] {""} ;
      P00KL2_A575TempRecPageSize = new short[1] ;
      P00KL2_A576TempRecHTMLBody = new String[] {""} ;
      P00KL2_A571TempRecDescrip = new String[] {""} ;
      P00KL2_A86TempRecSec = new short[1] ;
      P00KL2_A1139TempRecExplIIGG = new String[] {""} ;
      P00KL2_A1EmpCod = new short[1] ;
      A572TempRecHTML = "" ;
      A573TempRecHTMLRow = "" ;
      A574TempRecTipoRecibo = "" ;
      A576TempRecHTMLBody = "" ;
      A571TempRecDescrip = "" ;
      A1139TempRecExplIIGG = "" ;
      A972TempRecCss = "" ;
      A949TempRecRuta = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inicializartemplaterecibo__default(),
         new Object[] {
             new Object[] {
            P00KL2_A3CliCod, P00KL2_A572TempRecHTML, P00KL2_A573TempRecHTMLRow, P00KL2_A574TempRecTipoRecibo, P00KL2_A575TempRecPageSize, P00KL2_A576TempRecHTMLBody, P00KL2_A571TempRecDescrip, P00KL2_A86TempRecSec, P00KL2_A1139TempRecExplIIGG, P00KL2_A1EmpCod
            }
            , new Object[] {
            }
         }
      );
      AV31Pgmname = "inicializarTemplateRecibo" ;
      /* GeneXus formulas. */
      AV31Pgmname = "inicializarTemplateRecibo" ;
      Gx_err = (short)(0) ;
   }

   private short AV13EmpCod ;
   private short AV28PaiCod ;
   private short GXv_int1[] ;
   private short AV24i ;
   private short AV20TempRecPageSize ;
   private short A575TempRecPageSize ;
   private short A86TempRecSec ;
   private short A1EmpCod ;
   private short AV25TempRecSec ;
   private short Gx_err ;
   private int AV15CliCod ;
   private int AV14sistemaCliCod ;
   private int GXv_int2[] ;
   private int A3CliCod ;
   private int GX_INS74 ;
   private String GXv_char3[] ;
   private String AV31Pgmname ;
   private String AV19TempRecTipoRecibo ;
   private String scmdbuf ;
   private String A574TempRecTipoRecibo ;
   private String Gx_emsg ;
   private boolean returnInSub ;
   private String AV18TempRecHTML ;
   private String AV21TempRecHTMLBody ;
   private String AV27TempRecExplIIGG ;
   private String A572TempRecHTML ;
   private String A576TempRecHTMLBody ;
   private String A1139TempRecExplIIGG ;
   private String A972TempRecCss ;
   private String AV12rutaAplicacion ;
   private String AV23TempRecDescrip ;
   private String AV22ruta ;
   private String AV17TempRecHTMLRow ;
   private String AV26TempRecRuta ;
   private String A573TempRecHTMLRow ;
   private String A571TempRecDescrip ;
   private String A949TempRecRuta ;
   private com.genexus.util.GXFile AV8File ;
   private IDataStoreProvider pr_default ;
   private int[] P00KL2_A3CliCod ;
   private String[] P00KL2_A572TempRecHTML ;
   private String[] P00KL2_A573TempRecHTMLRow ;
   private String[] P00KL2_A574TempRecTipoRecibo ;
   private short[] P00KL2_A575TempRecPageSize ;
   private String[] P00KL2_A576TempRecHTMLBody ;
   private String[] P00KL2_A571TempRecDescrip ;
   private short[] P00KL2_A86TempRecSec ;
   private String[] P00KL2_A1139TempRecExplIIGG ;
   private short[] P00KL2_A1EmpCod ;
}

final  class inicializartemplaterecibo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00KL2", "SELECT CliCod, TempRecHTML, TempRecHTMLRow, TempRecTipoRecibo, TempRecPageSize, TempRecHTMLBody, TempRecDescrip, TempRecSec, TempRecExplIIGG, EmpCod FROM TemplateRecibo WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00KL3", "SAVEPOINT gxupdate;INSERT INTO TemplateRecibo(CliCod, EmpCod, TempRecSec, TempRecDescrip, TempRecHTML, TempRecHTMLBody, TempRecHTMLRow, TempRecTipoRecibo, TempRecPageSize, TempRecRuta, TempRecCss, TempRecExplIIGG) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setNLongVarchar(5, (String)parms[4], false);
               stmt.setNLongVarchar(6, (String)parms[5], false);
               stmt.setVarchar(7, (String)parms[6], 500, false);
               stmt.setString(8, (String)parms[7], 20);
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setVarchar(10, (String)parms[9], 800, false);
               stmt.setNLongVarchar(11, (String)parms[10], false);
               stmt.setNLongVarchar(12, (String)parms[11], false);
               return;
      }
   }

}

