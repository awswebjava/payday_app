package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newperiodo extends GXProcedure
{
   public newperiodo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newperiodo.class ), "" );
   }

   public newperiodo( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.util.Date aP2 ,
                        short aP3 ,
                        byte aP4 ,
                        String aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 ,
                             short aP3 ,
                             byte aP4 ,
                             String aP5 )
   {
      newperiodo.this.AV8CliCod = aP0;
      newperiodo.this.AV9EmpCod = aP1;
      newperiodo.this.AV10LiqPeriodo = aP2;
      newperiodo.this.AV11LiqPerAno = aP3;
      newperiodo.this.AV12LiqPerMes = aP4;
      newperiodo.this.AV13LiqPerPalabra = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV17GXLvl1 = (byte)(0) ;
      /* Using cursor P01Z42 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), AV10LiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1729PeriodoLiq = P01Z42_A1729PeriodoLiq[0] ;
         A1EmpCod = P01Z42_A1EmpCod[0] ;
         A3CliCod = P01Z42_A3CliCod[0] ;
         AV17GXLvl1 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV17GXLvl1 == 0 )
      {
         /*
            INSERT RECORD ON TABLE Periodo

         */
         A3CliCod = AV8CliCod ;
         A1EmpCod = AV9EmpCod ;
         A1729PeriodoLiq = AV10LiqPeriodo ;
         A1730PeriodoAnio = AV11LiqPerAno ;
         A1731PeriodoMes = AV12LiqPerMes ;
         A1732PeriodoDescrip = AV13LiqPerPalabra ;
         AV14palabra = GXutil.trim( GXutil.str( AV11LiqPerAno, 4, 0)) + GXutil.padl( GXutil.str( AV12LiqPerMes, 2, 0), (short)(2), "0") ;
         A2103PeriodoAnioMes = (int)(GXutil.lval( AV14palabra)) ;
         /* Using cursor P01Z43 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), A1729PeriodoLiq, Short.valueOf(A1730PeriodoAnio), Byte.valueOf(A1731PeriodoMes), A1732PeriodoDescrip, Integer.valueOf(A2103PeriodoAnioMes)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Periodo");
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
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newperiodo");
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
      P01Z42_A1729PeriodoLiq = new java.util.Date[] {GXutil.nullDate()} ;
      P01Z42_A1EmpCod = new short[1] ;
      P01Z42_A3CliCod = new int[1] ;
      A1729PeriodoLiq = GXutil.nullDate() ;
      A1732PeriodoDescrip = "" ;
      AV14palabra = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newperiodo__default(),
         new Object[] {
             new Object[] {
            P01Z42_A1729PeriodoLiq, P01Z42_A1EmpCod, P01Z42_A3CliCod
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV12LiqPerMes ;
   private byte AV17GXLvl1 ;
   private byte A1731PeriodoMes ;
   private short AV9EmpCod ;
   private short AV11LiqPerAno ;
   private short A1EmpCod ;
   private short A1730PeriodoAnio ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private int GX_INS233 ;
   private int A2103PeriodoAnioMes ;
   private String AV13LiqPerPalabra ;
   private String scmdbuf ;
   private String AV14palabra ;
   private String Gx_emsg ;
   private java.util.Date AV10LiqPeriodo ;
   private java.util.Date A1729PeriodoLiq ;
   private String A1732PeriodoDescrip ;
   private IDataStoreProvider pr_default ;
   private java.util.Date[] P01Z42_A1729PeriodoLiq ;
   private short[] P01Z42_A1EmpCod ;
   private int[] P01Z42_A3CliCod ;
}

final  class newperiodo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01Z42", "SELECT PeriodoLiq, EmpCod, CliCod FROM Periodo WHERE CliCod = ? and EmpCod = ? and PeriodoLiq = ? ORDER BY CliCod, EmpCod, PeriodoLiq  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01Z43", "SAVEPOINT gxupdate;INSERT INTO Periodo(CliCod, EmpCod, PeriodoLiq, PeriodoAnio, PeriodoMes, PeriodoDescrip, PeriodoAnioMes) VALUES(?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
      }
   }

}

