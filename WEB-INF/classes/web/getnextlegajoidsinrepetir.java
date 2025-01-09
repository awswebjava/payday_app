package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnextlegajoidsinrepetir extends GXProcedure
{
   public getnextlegajoidsinrepetir( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnextlegajoidsinrepetir.class ), "" );
   }

   public getnextlegajoidsinrepetir( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             long[] aP2 )
   {
      getnextlegajoidsinrepetir.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        long[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             long[] aP2 ,
                             String[] aP3 )
   {
      getnextlegajoidsinrepetir.this.AV13CliCod = aP0;
      getnextlegajoidsinrepetir.this.AV14EmpCod = aP1;
      getnextlegajoidsinrepetir.this.AV9ultimoId = aP2[0];
      this.aP2 = aP2;
      getnextlegajoidsinrepetir.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10continuar = true ;
      while ( AV10continuar )
      {
         AV15legHay = true ;
         AV16migrHay = true ;
         GXt_char1 = AV17idTempPalabra ;
         GXv_char2[0] = GXt_char1 ;
         new web.migrtidtemppalabra(remoteHandle, context).execute( GXv_char2) ;
         getnextlegajoidsinrepetir.this.GXt_char1 = GXv_char2[0] ;
         AV17idTempPalabra = GXt_char1 ;
         AV8LegId = GXutil.trim( AV17idTempPalabra) + GXutil.trim( GXutil.str( AV9ultimoId, 15, 0)) ;
         AV20GXLvl9 = (byte)(0) ;
         /* Using cursor P027R2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV14EmpCod), AV8LegId});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A93LegId = P027R2_A93LegId[0] ;
            n93LegId = P027R2_n93LegId[0] ;
            A1EmpCod = P027R2_A1EmpCod[0] ;
            A3CliCod = P027R2_A3CliCod[0] ;
            A6LegNumero = P027R2_A6LegNumero[0] ;
            AV20GXLvl9 = (byte)(1) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV20GXLvl9 == 0 )
         {
            AV15legHay = false ;
         }
         AV21GXLvl18 = (byte)(0) ;
         /* Using cursor P027R3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV14EmpCod), AV8LegId});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A626MigrLegId = P027R3_A626MigrLegId[0] ;
            A1EmpCod = P027R3_A1EmpCod[0] ;
            A3CliCod = P027R3_A3CliCod[0] ;
            A87MigrLegNumero = P027R3_A87MigrLegNumero[0] ;
            AV21GXLvl18 = (byte)(1) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( AV21GXLvl18 == 0 )
         {
            AV16migrHay = false ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "no hay migr con id \"", "")+AV8LegId+"\"") ;
         }
         if ( ! AV15legHay && ! AV16migrHay )
         {
            AV10continuar = false ;
         }
         AV9ultimoId = (long)(AV9ultimoId+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getnextlegajoidsinrepetir.this.AV9ultimoId;
      this.aP3[0] = getnextlegajoidsinrepetir.this.AV8LegId;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8LegId = "" ;
      AV17idTempPalabra = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      scmdbuf = "" ;
      P027R2_A93LegId = new String[] {""} ;
      P027R2_n93LegId = new boolean[] {false} ;
      P027R2_A1EmpCod = new short[1] ;
      P027R2_A3CliCod = new int[1] ;
      P027R2_A6LegNumero = new int[1] ;
      A93LegId = "" ;
      P027R3_A626MigrLegId = new String[] {""} ;
      P027R3_A1EmpCod = new short[1] ;
      P027R3_A3CliCod = new int[1] ;
      P027R3_A87MigrLegNumero = new int[1] ;
      A626MigrLegId = "" ;
      AV22Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getnextlegajoidsinrepetir__default(),
         new Object[] {
             new Object[] {
            P027R2_A93LegId, P027R2_n93LegId, P027R2_A1EmpCod, P027R2_A3CliCod, P027R2_A6LegNumero
            }
            , new Object[] {
            P027R3_A626MigrLegId, P027R3_A1EmpCod, P027R3_A3CliCod, P027R3_A87MigrLegNumero
            }
         }
      );
      AV22Pgmname = "getNextLegajoIdSinRepetir" ;
      /* GeneXus formulas. */
      AV22Pgmname = "getNextLegajoIdSinRepetir" ;
      Gx_err = (short)(0) ;
   }

   private byte AV20GXLvl9 ;
   private byte AV21GXLvl18 ;
   private short AV14EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A87MigrLegNumero ;
   private long AV9ultimoId ;
   private String AV8LegId ;
   private String AV17idTempPalabra ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String scmdbuf ;
   private String A93LegId ;
   private String A626MigrLegId ;
   private String AV22Pgmname ;
   private boolean AV10continuar ;
   private boolean AV15legHay ;
   private boolean AV16migrHay ;
   private boolean n93LegId ;
   private String[] aP3 ;
   private long[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P027R2_A93LegId ;
   private boolean[] P027R2_n93LegId ;
   private short[] P027R2_A1EmpCod ;
   private int[] P027R2_A3CliCod ;
   private int[] P027R2_A6LegNumero ;
   private String[] P027R3_A626MigrLegId ;
   private short[] P027R3_A1EmpCod ;
   private int[] P027R3_A3CliCod ;
   private int[] P027R3_A87MigrLegNumero ;
}

final  class getnextlegajoidsinrepetir__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P027R2", "SELECT LegId, EmpCod, CliCod, LegNumero FROM Legajo WHERE (CliCod = ? and EmpCod = ?) AND (LegId = ( ?)) ORDER BY CliCod, EmpCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P027R3", "SELECT MigrLegId, EmpCod, CliCod, MigrLegNumero FROM importacion_legajo WHERE (CliCod = ? and EmpCod = ?) AND (MigrLegId = ( ?)) ORDER BY CliCod, EmpCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
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
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

