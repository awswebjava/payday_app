package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inicializarferiados extends GXProcedure
{
   public inicializarferiados( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inicializarferiados.class ), "" );
   }

   public inicializarferiados( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( short aP0 )
   {
      inicializarferiados.this.AV12PaiCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11anio = (short)(2020) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, "1") ;
      /*
         INSERT RECORD ON TABLE tipo_feriado

      */
      A46PaiCod = AV12PaiCod ;
      A1221FerTipo = "inamovible" ;
      A1785FerTipoDescrip = httpContext.getMessage( "Feriado inamovible", "") ;
      /* Using cursor P013Q2 */
      pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), A1221FerTipo, A1785FerTipoDescrip});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("tipo_feriado");
      if ( (pr_default.getStatus(0) == 1) )
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
      /*
         INSERT RECORD ON TABLE tipo_feriado

      */
      A46PaiCod = AV12PaiCod ;
      A1221FerTipo = "trasladable" ;
      A1785FerTipoDescrip = httpContext.getMessage( "Feriado trasladable", "") ;
      /* Using cursor P013Q3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), A1221FerTipo, A1785FerTipoDescrip});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("tipo_feriado");
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
      /*
         INSERT RECORD ON TABLE tipo_feriado

      */
      A46PaiCod = AV12PaiCod ;
      A1221FerTipo = "nolaborable" ;
      A1785FerTipoDescrip = httpContext.getMessage( "Día no laborable", "") ;
      /* Using cursor P013Q4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A46PaiCod), A1221FerTipo, A1785FerTipoDescrip});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("tipo_feriado");
      if ( (pr_default.getStatus(2) == 1) )
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
      /*
         INSERT RECORD ON TABLE tipo_feriado

      */
      A46PaiCod = AV12PaiCod ;
      A1221FerTipo = "puente" ;
      A1785FerTipoDescrip = httpContext.getMessage( "Feriado puente", "") ;
      /* Using cursor P013Q5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A46PaiCod), A1221FerTipo, A1785FerTipoDescrip});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("tipo_feriado");
      if ( (pr_default.getStatus(3) == 1) )
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
      while ( AV11anio <= 2024 )
      {
         GXv_char1[0] = "" ;
         new web.importarferiadosagenda(remoteHandle, context).execute( AV12PaiCod, AV11anio, GXv_char1) ;
         AV11anio = (short)(AV11anio+1) ;
      }
      /*
         INSERT RECORD ON TABLE feriado_agenda

      */
      A46PaiCod = AV12PaiCod ;
      A1223FerId = httpContext.getMessage( "carnaval", "") ;
      A1226FerAnio = AV11anio ;
      A1227FerFecha = localUtil.ymdtod( AV11anio, 2, 21) ;
      /* Using cursor P013Q6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A46PaiCod), A1223FerId, Short.valueOf(A1226FerAnio), A1227FerFecha});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("feriado_agenda");
      if ( (pr_default.getStatus(4) == 1) )
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
      /*
         INSERT RECORD ON TABLE feriado_agenda

      */
      A46PaiCod = AV12PaiCod ;
      A1223FerId = httpContext.getMessage( "puente-turistico", "") ;
      A1226FerAnio = AV11anio ;
      A1227FerFecha = localUtil.ymdtod( AV11anio, 6, 19) ;
      /* Using cursor P013Q7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A46PaiCod), A1223FerId, Short.valueOf(A1226FerAnio), A1227FerFecha});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("feriado_agenda");
      if ( (pr_default.getStatus(5) == 1) )
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
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "inicializarferiados");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19Pgmname = "" ;
      A1221FerTipo = "" ;
      A1785FerTipoDescrip = "" ;
      Gx_emsg = "" ;
      GXv_char1 = new String[1] ;
      A1223FerId = "" ;
      A1227FerFecha = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inicializarferiados__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV19Pgmname = "inicializarFeriados" ;
      /* GeneXus formulas. */
      AV19Pgmname = "inicializarFeriados" ;
      Gx_err = (short)(0) ;
   }

   private short AV12PaiCod ;
   private short AV11anio ;
   private short A46PaiCod ;
   private short Gx_err ;
   private short A1226FerAnio ;
   private int GX_INS139 ;
   private int GX_INS243 ;
   private String AV19Pgmname ;
   private String A1221FerTipo ;
   private String Gx_emsg ;
   private String GXv_char1[] ;
   private String A1223FerId ;
   private java.util.Date A1227FerFecha ;
   private String A1785FerTipoDescrip ;
   private IDataStoreProvider pr_default ;
}

final  class inicializarferiados__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P013Q2", "SAVEPOINT gxupdate;INSERT INTO tipo_feriado(PaiCod, FerTipo, FerTipoDescrip) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P013Q3", "SAVEPOINT gxupdate;INSERT INTO tipo_feriado(PaiCod, FerTipo, FerTipoDescrip) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P013Q4", "SAVEPOINT gxupdate;INSERT INTO tipo_feriado(PaiCod, FerTipo, FerTipoDescrip) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P013Q5", "SAVEPOINT gxupdate;INSERT INTO tipo_feriado(PaiCod, FerTipo, FerTipoDescrip) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P013Q6", "SAVEPOINT gxupdate;INSERT INTO feriado_agenda(PaiCod, FerId, FerAnio, FerFecha) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P013Q7", "SAVEPOINT gxupdate;INSERT INTO feriado_agenda(PaiCod, FerId, FerAnio, FerFecha) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
      }
   }

}

