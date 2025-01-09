package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inicializarferiadosgremio extends GXProcedure
{
   public inicializarferiadosgremio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inicializarferiadosgremio.class ), "" );
   }

   public inicializarferiadosgremio( int remoteHandle ,
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
      inicializarferiadosgremio.this.AV8PaiCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE feriado

      */
      A46PaiCod = AV8PaiCod ;
      A1223FerId = httpContext.getMessage( "diaDeUocra", "") ;
      A1228FerDescrip = httpContext.getMessage( "Día del empleado de la construcción (UOCRA)", "") ;
      A1230FerReligId = "" ;
      n1230FerReligId = false ;
      n1230FerReligId = true ;
      A1232FerOrigId = "" ;
      n1232FerOrigId = false ;
      n1232FerOrigId = true ;
      A1233FeriadoTipo = "inamovible" ;
      GXt_char1 = A1234FeriadoConvenio ;
      GXv_char2[0] = GXt_char1 ;
      new web.conveniouocra(remoteHandle, context).execute( GXv_char2) ;
      inicializarferiadosgremio.this.GXt_char1 = GXv_char2[0] ;
      A1234FeriadoConvenio = GXt_char1 ;
      n1234FeriadoConvenio = false ;
      /* Using cursor P01MR2 */
      pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), A1223FerId, A1228FerDescrip, Boolean.valueOf(n1230FerReligId), A1230FerReligId, Boolean.valueOf(n1232FerOrigId), A1232FerOrigId, A1233FeriadoTipo, Boolean.valueOf(n1234FeriadoConvenio), A1234FeriadoConvenio});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("feriado");
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
         INSERT RECORD ON TABLE feriado

      */
      A46PaiCod = AV8PaiCod ;
      A1223FerId = httpContext.getMessage( "diaDeUocraYac", "") ;
      A1228FerDescrip = httpContext.getMessage( "Día del empleado de la construcción (UOCRAYAC)", "") ;
      A1230FerReligId = "" ;
      n1230FerReligId = false ;
      n1230FerReligId = true ;
      A1232FerOrigId = "" ;
      n1232FerOrigId = false ;
      n1232FerOrigId = true ;
      A1233FeriadoTipo = "inamovible" ;
      GXt_char1 = A1234FeriadoConvenio ;
      GXv_char2[0] = GXt_char1 ;
      new web.conveniouocrayac(remoteHandle, context).execute( GXv_char2) ;
      inicializarferiadosgremio.this.GXt_char1 = GXv_char2[0] ;
      A1234FeriadoConvenio = GXt_char1 ;
      n1234FeriadoConvenio = false ;
      /* Using cursor P01MR3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), A1223FerId, A1228FerDescrip, Boolean.valueOf(n1230FerReligId), A1230FerReligId, Boolean.valueOf(n1232FerOrigId), A1232FerOrigId, A1233FeriadoTipo, Boolean.valueOf(n1234FeriadoConvenio), A1234FeriadoConvenio});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("feriado");
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
         INSERT RECORD ON TABLE feriado

      */
      A46PaiCod = AV8PaiCod ;
      A1223FerId = httpContext.getMessage( "diaDeUecara", "") ;
      A1228FerDescrip = httpContext.getMessage( "Día del empleado de la construcción (UECARA)", "") ;
      A1230FerReligId = "" ;
      n1230FerReligId = false ;
      n1230FerReligId = true ;
      A1232FerOrigId = "" ;
      n1232FerOrigId = false ;
      n1232FerOrigId = true ;
      A1233FeriadoTipo = "inamovible" ;
      GXt_char1 = A1234FeriadoConvenio ;
      GXv_char2[0] = GXt_char1 ;
      new web.conveniouecara(remoteHandle, context).execute( GXv_char2) ;
      inicializarferiadosgremio.this.GXt_char1 = GXv_char2[0] ;
      A1234FeriadoConvenio = GXt_char1 ;
      n1234FeriadoConvenio = false ;
      /* Using cursor P01MR4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A46PaiCod), A1223FerId, A1228FerDescrip, Boolean.valueOf(n1230FerReligId), A1230FerReligId, Boolean.valueOf(n1232FerOrigId), A1232FerOrigId, A1233FeriadoTipo, Boolean.valueOf(n1234FeriadoConvenio), A1234FeriadoConvenio});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("feriado");
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
         INSERT RECORD ON TABLE feriado_agenda

      */
      A46PaiCod = AV8PaiCod ;
      A1223FerId = httpContext.getMessage( "diaDeUocra", "") ;
      A1226FerAnio = (short)(2023) ;
      A1227FerFecha = localUtil.ymdtod( 2023, 4, 22) ;
      /* Using cursor P01MR5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A46PaiCod), A1223FerId, Short.valueOf(A1226FerAnio), A1227FerFecha});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("feriado_agenda");
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
      /*
         INSERT RECORD ON TABLE feriado_agenda

      */
      A46PaiCod = AV8PaiCod ;
      A1223FerId = httpContext.getMessage( "diaDeUocraYac", "") ;
      A1226FerAnio = (short)(2023) ;
      A1227FerFecha = localUtil.ymdtod( 2023, 4, 22) ;
      /* Using cursor P01MR6 */
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
      A46PaiCod = AV8PaiCod ;
      A1223FerId = httpContext.getMessage( "diaDeUecara", "") ;
      A1226FerAnio = (short)(2023) ;
      A1227FerFecha = localUtil.ymdtod( 2023, 4, 22) ;
      /* Using cursor P01MR7 */
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
      /*
         INSERT RECORD ON TABLE feriado_agenda

      */
      A46PaiCod = AV8PaiCod ;
      A1223FerId = httpContext.getMessage( "diaDeUocra", "") ;
      A1226FerAnio = (short)(2024) ;
      A1227FerFecha = localUtil.ymdtod( 2024, 4, 22) ;
      /* Using cursor P01MR8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A46PaiCod), A1223FerId, Short.valueOf(A1226FerAnio), A1227FerFecha});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("feriado_agenda");
      if ( (pr_default.getStatus(6) == 1) )
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
      A46PaiCod = AV8PaiCod ;
      A1223FerId = httpContext.getMessage( "diaDeUocraYac", "") ;
      A1226FerAnio = (short)(2024) ;
      A1227FerFecha = localUtil.ymdtod( 2024, 4, 22) ;
      /* Using cursor P01MR9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A46PaiCod), A1223FerId, Short.valueOf(A1226FerAnio), A1227FerFecha});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("feriado_agenda");
      if ( (pr_default.getStatus(7) == 1) )
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
      A46PaiCod = AV8PaiCod ;
      A1223FerId = httpContext.getMessage( "diaDeUecara", "") ;
      A1226FerAnio = (short)(2024) ;
      A1227FerFecha = localUtil.ymdtod( 2024, 4, 22) ;
      /* Using cursor P01MR10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A46PaiCod), A1223FerId, Short.valueOf(A1226FerAnio), A1227FerFecha});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("feriado_agenda");
      if ( (pr_default.getStatus(8) == 1) )
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
      Application.commitDataStores(context, remoteHandle, pr_default, "inicializarferiadosgremio");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1223FerId = "" ;
      A1228FerDescrip = "" ;
      A1230FerReligId = "" ;
      A1232FerOrigId = "" ;
      A1233FeriadoTipo = "" ;
      A1234FeriadoConvenio = "" ;
      Gx_emsg = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      A1227FerFecha = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inicializarferiadosgremio__default(),
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
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private short A1226FerAnio ;
   private int GX_INS140 ;
   private int GX_INS243 ;
   private String A1223FerId ;
   private String A1230FerReligId ;
   private String A1232FerOrigId ;
   private String A1233FeriadoTipo ;
   private String A1234FeriadoConvenio ;
   private String Gx_emsg ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private java.util.Date A1227FerFecha ;
   private boolean n1230FerReligId ;
   private boolean n1232FerOrigId ;
   private boolean n1234FeriadoConvenio ;
   private String A1228FerDescrip ;
   private IDataStoreProvider pr_default ;
}

final  class inicializarferiadosgremio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01MR2", "SAVEPOINT gxupdate;INSERT INTO feriado(PaiCod, FerId, FerDescrip, FerReligId, FerOrigId, FeriadoTipo, FeriadoConvenio, FerDia, FerMes) VALUES(?, ?, ?, ?, ?, ?, ?, 0, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01MR3", "SAVEPOINT gxupdate;INSERT INTO feriado(PaiCod, FerId, FerDescrip, FerReligId, FerOrigId, FeriadoTipo, FeriadoConvenio, FerDia, FerMes) VALUES(?, ?, ?, ?, ?, ?, ?, 0, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01MR4", "SAVEPOINT gxupdate;INSERT INTO feriado(PaiCod, FerId, FerDescrip, FerReligId, FerOrigId, FeriadoTipo, FeriadoConvenio, FerDia, FerMes) VALUES(?, ?, ?, ?, ?, ?, ?, 0, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01MR5", "SAVEPOINT gxupdate;INSERT INTO feriado_agenda(PaiCod, FerId, FerAnio, FerFecha) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01MR6", "SAVEPOINT gxupdate;INSERT INTO feriado_agenda(PaiCod, FerId, FerAnio, FerFecha) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01MR7", "SAVEPOINT gxupdate;INSERT INTO feriado_agenda(PaiCod, FerId, FerAnio, FerFecha) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01MR8", "SAVEPOINT gxupdate;INSERT INTO feriado_agenda(PaiCod, FerId, FerAnio, FerFecha) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01MR9", "SAVEPOINT gxupdate;INSERT INTO feriado_agenda(PaiCod, FerId, FerAnio, FerFecha) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01MR10", "SAVEPOINT gxupdate;INSERT INTO feriado_agenda(PaiCod, FerId, FerAnio, FerFecha) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setString(2, (String)parms[1], 40);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[4], 20);
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[6], 20);
               }
               stmt.setString(6, (String)parms[7], 20);
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[9], 20);
               }
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[4], 20);
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[6], 20);
               }
               stmt.setString(6, (String)parms[7], 20);
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[9], 20);
               }
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[4], 20);
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[6], 20);
               }
               stmt.setString(6, (String)parms[7], 20);
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[9], 20);
               }
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
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
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
      }
   }

}

