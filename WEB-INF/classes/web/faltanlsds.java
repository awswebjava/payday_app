package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class faltanlsds extends GXProcedure
{
   public faltanlsds( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( faltanlsds.class ), "" );
   }

   public faltanlsds( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              GXSimpleCollection<Integer> aP3 )
   {
      faltanlsds.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<Integer> aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             boolean[] aP4 )
   {
      faltanlsds.this.AV11CliCod = aP0;
      faltanlsds.this.AV10EmpCod = aP1;
      faltanlsds.this.AV9LiqNro = aP2;
      faltanlsds.this.AV8LegNumero = aP3;
      faltanlsds.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV14i = (short)(1) ;
      while ( AV14i <= AV8LegNumero.size() )
      {
         AV13AuxLegNumero = ((Number) AV8LegNumero.elementAt(-1+AV14i)).intValue() ;
         /* Using cursor P02JR2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV13AuxLegNumero)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A2400LiqLegLSD = P02JR2_A2400LiqLegLSD[0] ;
            A6LegNumero = P02JR2_A6LegNumero[0] ;
            A31LiqNro = P02JR2_A31LiqNro[0] ;
            A1EmpCod = P02JR2_A1EmpCod[0] ;
            A3CliCod = P02JR2_A3CliCod[0] ;
            AV12falta = true ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         AV14i = (short)(AV14i+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = faltanlsds.this.AV12falta;
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
      P02JR2_A2400LiqLegLSD = new byte[1] ;
      P02JR2_A6LegNumero = new int[1] ;
      P02JR2_A31LiqNro = new int[1] ;
      P02JR2_A1EmpCod = new short[1] ;
      P02JR2_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.faltanlsds__default(),
         new Object[] {
             new Object[] {
            P02JR2_A2400LiqLegLSD, P02JR2_A6LegNumero, P02JR2_A31LiqNro, P02JR2_A1EmpCod, P02JR2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A2400LiqLegLSD ;
   private short AV10EmpCod ;
   private short AV14i ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LiqNro ;
   private int AV13AuxLegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String scmdbuf ;
   private boolean AV12falta ;
   private GXSimpleCollection<Integer> AV8LegNumero ;
   private boolean[] aP4 ;
   private IDataStoreProvider pr_default ;
   private byte[] P02JR2_A2400LiqLegLSD ;
   private int[] P02JR2_A6LegNumero ;
   private int[] P02JR2_A31LiqNro ;
   private short[] P02JR2_A1EmpCod ;
   private int[] P02JR2_A3CliCod ;
}

final  class faltanlsds__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02JR2", "SELECT LiqLegLSD, LegNumero, LiqNro, EmpCod, CliCod FROM LiquidacionLegajo WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?) AND (LiqLegLSD = 0) ORDER BY CliCod, EmpCod, LiqNro, LegNumero  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

