package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class crearimportacion extends GXProcedure
{
   public crearimportacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( crearimportacion.class ), "" );
   }

   public crearimportacion( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public long executeUdp( int aP0 )
   {
      crearimportacion.this.aP1 = new long[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        long[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             long[] aP1 )
   {
      crearimportacion.this.AV9CliCod = aP0;
      crearimportacion.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00BB2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00BB2_A3CliCod[0] ;
         A52ImpSec = P00BB2_A52ImpSec[0] ;
         AV8ImpSec = A52ImpSec ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV8ImpSec = (long)(AV8ImpSec+1) ;
      /*
         INSERT RECORD ON TABLE Importacion

      */
      A3CliCod = AV9CliCod ;
      A52ImpSec = AV8ImpSec ;
      A225ImpFecha = GXutil.serverNow( context, remoteHandle, pr_default) ;
      GXt_char1 = A226ImpUsuario ;
      GXv_char2[0] = GXt_char1 ;
      new web.getusulogged(remoteHandle, context).execute( GXv_char2) ;
      crearimportacion.this.GXt_char1 = GXv_char2[0] ;
      A226ImpUsuario = GXt_char1 ;
      /* Using cursor P00BB3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Long.valueOf(A52ImpSec), A225ImpFecha, A226ImpUsuario});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Importacion");
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
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = crearimportacion.this.AV8ImpSec;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P00BB2_A3CliCod = new int[1] ;
      P00BB2_A52ImpSec = new long[1] ;
      A225ImpFecha = GXutil.resetTime( GXutil.nullDate() );
      A226ImpUsuario = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.crearimportacion__default(),
         new Object[] {
             new Object[] {
            P00BB2_A3CliCod, P00BB2_A52ImpSec
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private int GX_INS22 ;
   private long AV8ImpSec ;
   private long A52ImpSec ;
   private String scmdbuf ;
   private String A226ImpUsuario ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String Gx_emsg ;
   private java.util.Date A225ImpFecha ;
   private long[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P00BB2_A3CliCod ;
   private long[] P00BB2_A52ImpSec ;
}

final  class crearimportacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00BB2", "SELECT CliCod, ImpSec FROM Importacion WHERE CliCod = ? ORDER BY CliCod, ImpSec DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00BB3", "SAVEPOINT gxupdate;INSERT INTO Importacion(CliCod, ImpSec, ImpFecha, ImpUsuario) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((long[]) buf[1])[0] = rslt.getLong(2);
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
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setDateTime(3, (java.util.Date)parms[2], false);
               stmt.setString(4, (String)parms[3], 200);
               return;
      }
   }

}

