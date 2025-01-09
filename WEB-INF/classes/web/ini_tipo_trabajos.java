package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_tipo_trabajos extends GXProcedure
{
   public ini_tipo_trabajos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_tipo_trabajos.class ), "" );
   }

   public ini_tipo_trabajos( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE TipoTrabajo

      */
      A1292TipoTraId = "diurno" ;
      A1293TipoTraNom = httpContext.getMessage( "Diurno", "") ;
      /* Using cursor P01HP2 */
      pr_default.execute(0, new Object[] {A1292TipoTraId, A1293TipoTraNom});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoTrabajo");
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
         INSERT RECORD ON TABLE TipoTrabajo

      */
      A1292TipoTraId = "nocturno" ;
      A1293TipoTraNom = httpContext.getMessage( "Nocturno", "") ;
      /* Using cursor P01HP3 */
      pr_default.execute(1, new Object[] {A1292TipoTraId, A1293TipoTraNom});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoTrabajo");
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
         INSERT RECORD ON TABLE TipoTrabajo

      */
      A1292TipoTraId = "insalubre" ;
      A1293TipoTraNom = httpContext.getMessage( "Insalubre", "") ;
      /* Using cursor P01HP4 */
      pr_default.execute(2, new Object[] {A1292TipoTraId, A1293TipoTraNom});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("TipoTrabajo");
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
         INSERT RECORD ON TABLE actividadcomercial

      */
      GXt_char1 = A903ActComCodigo ;
      GXv_char2[0] = GXt_char1 ;
      new web.actcomconstruccion(remoteHandle, context).execute( GXv_char2) ;
      ini_tipo_trabajos.this.GXt_char1 = GXv_char2[0] ;
      A903ActComCodigo = GXt_char1 ;
      A904ActComDescripcion = httpContext.getMessage( "Construcción", "") ;
      /* Using cursor P01HP5 */
      pr_default.execute(3, new Object[] {A903ActComCodigo, A904ActComDescripcion});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("actividadcomercial");
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
         INSERT RECORD ON TABLE actividadcomercial

      */
      A903ActComCodigo = httpContext.getMessage( "COMERCIO", "") ;
      A904ActComDescripcion = httpContext.getMessage( "Comercio", "") ;
      /* Using cursor P01HP6 */
      pr_default.execute(4, new Object[] {A903ActComCodigo, A904ActComDescripcion});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("actividadcomercial");
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
         INSERT RECORD ON TABLE actividadcomercial

      */
      A903ActComCodigo = httpContext.getMessage( "TRANSPORTE", "") ;
      A904ActComDescripcion = httpContext.getMessage( "Transporte", "") ;
      /* Using cursor P01HP7 */
      pr_default.execute(5, new Object[] {A903ActComCodigo, A904ActComDescripcion});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("actividadcomercial");
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
         INSERT RECORD ON TABLE actividadcomercial

      */
      A903ActComCodigo = httpContext.getMessage( "ALIMENTACION", "") ;
      A904ActComDescripcion = httpContext.getMessage( "Alimentación", "") ;
      /* Using cursor P01HP8 */
      pr_default.execute(6, new Object[] {A903ActComCodigo, A904ActComDescripcion});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("actividadcomercial");
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
         INSERT RECORD ON TABLE actividadcomercial

      */
      A903ActComCodigo = httpContext.getMessage( "METALURGICA", "") ;
      A904ActComDescripcion = httpContext.getMessage( "Metalúrgica", "") ;
      /* Using cursor P01HP9 */
      pr_default.execute(7, new Object[] {A903ActComCodigo, A904ActComDescripcion});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("actividadcomercial");
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
         INSERT RECORD ON TABLE actividadcomercial

      */
      A903ActComCodigo = httpContext.getMessage( "PETROLEROS", "") ;
      A904ActComDescripcion = httpContext.getMessage( "Petroleros", "") ;
      /* Using cursor P01HP10 */
      pr_default.execute(8, new Object[] {A903ActComCodigo, A904ActComDescripcion});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("actividadcomercial");
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
      /*
         INSERT RECORD ON TABLE actividadcomercial

      */
      A903ActComCodigo = httpContext.getMessage( "OTRA", "") ;
      A904ActComDescripcion = httpContext.getMessage( "Otra", "") ;
      /* Using cursor P01HP11 */
      pr_default.execute(9, new Object[] {A903ActComCodigo, A904ActComDescripcion});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("actividadcomercial");
      if ( (pr_default.getStatus(9) == 1) )
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
         INSERT RECORD ON TABLE actividadcomercial

      */
      A903ActComCodigo = httpContext.getMessage( "INFORMATICA", "") ;
      A904ActComDescripcion = httpContext.getMessage( "Informática", "") ;
      /* Using cursor P01HP12 */
      pr_default.execute(10, new Object[] {A903ActComCodigo, A904ActComDescripcion});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("actividadcomercial");
      if ( (pr_default.getStatus(10) == 1) )
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
         INSERT RECORD ON TABLE actividadcomercial

      */
      A903ActComCodigo = httpContext.getMessage( "GASTRONOMIA", "") ;
      A904ActComDescripcion = httpContext.getMessage( "Gastronomía", "") ;
      /* Using cursor P01HP13 */
      pr_default.execute(11, new Object[] {A903ActComCodigo, A904ActComDescripcion});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("actividadcomercial");
      if ( (pr_default.getStatus(11) == 1) )
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
      Application.commitDataStores(context, remoteHandle, pr_default, "ini_tipo_trabajos");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1292TipoTraId = "" ;
      A1293TipoTraNom = "" ;
      Gx_emsg = "" ;
      A903ActComCodigo = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      A904ActComDescripcion = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ini_tipo_trabajos__default(),
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

   private short Gx_err ;
   private int GX_INS154 ;
   private int GX_INS100 ;
   private String A1292TipoTraId ;
   private String Gx_emsg ;
   private String A903ActComCodigo ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String A1293TipoTraNom ;
   private String A904ActComDescripcion ;
   private IDataStoreProvider pr_default ;
}

final  class ini_tipo_trabajos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01HP2", "SAVEPOINT gxupdate;INSERT INTO TipoTrabajo(TipoTraId, TipoTraNom) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HP3", "SAVEPOINT gxupdate;INSERT INTO TipoTrabajo(TipoTraId, TipoTraNom) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HP4", "SAVEPOINT gxupdate;INSERT INTO TipoTrabajo(TipoTraId, TipoTraNom) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HP5", "SAVEPOINT gxupdate;INSERT INTO actividadcomercial(ActComCodigo, ActComDescripcion) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HP6", "SAVEPOINT gxupdate;INSERT INTO actividadcomercial(ActComCodigo, ActComDescripcion) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HP7", "SAVEPOINT gxupdate;INSERT INTO actividadcomercial(ActComCodigo, ActComDescripcion) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HP8", "SAVEPOINT gxupdate;INSERT INTO actividadcomercial(ActComCodigo, ActComDescripcion) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HP9", "SAVEPOINT gxupdate;INSERT INTO actividadcomercial(ActComCodigo, ActComDescripcion) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HP10", "SAVEPOINT gxupdate;INSERT INTO actividadcomercial(ActComCodigo, ActComDescripcion) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HP11", "SAVEPOINT gxupdate;INSERT INTO actividadcomercial(ActComCodigo, ActComDescripcion) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HP12", "SAVEPOINT gxupdate;INSERT INTO actividadcomercial(ActComCodigo, ActComDescripcion) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HP13", "SAVEPOINT gxupdate;INSERT INTO actividadcomercial(ActComCodigo, ActComDescripcion) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 30, false);
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 30, false);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 30, false);
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               return;
            case 4 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               return;
            case 5 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               return;
            case 7 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               return;
            case 9 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               return;
            case 10 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               return;
            case 11 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               return;
      }
   }

}

