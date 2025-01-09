package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empleadosexo extends GXProcedure
{
   public empleadosexo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empleadosexo.class ), "" );
   }

   public empleadosexo( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             byte aP3 )
   {
      empleadosexo.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        byte aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             byte aP3 ,
                             String[] aP4 )
   {
      empleadosexo.this.AV15CliCod = aP0;
      empleadosexo.this.AV16empcod = aP1;
      empleadosexo.this.AV8LegNumero = aP2;
      empleadosexo.this.AV13legSexo = aP3;
      empleadosexo.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV20GXLvl14 = (byte)(0) ;
      /* Using cursor P004Y2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV15CliCod), Short.valueOf(AV16empcod), Integer.valueOf(AV8LegNumero), Byte.valueOf(AV13legSexo)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A263LegSexo = P004Y2_A263LegSexo[0] ;
         n263LegSexo = P004Y2_n263LegSexo[0] ;
         A6LegNumero = P004Y2_A6LegNumero[0] ;
         A1EmpCod = P004Y2_A1EmpCod[0] ;
         A3CliCod = P004Y2_A3CliCod[0] ;
         AV20GXLvl14 = (byte)(1) ;
         AV12tiene = "1" ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV20GXLvl14 == 0 )
      {
         AV12tiene = "0" ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = empleadosexo.this.AV12tiene;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12tiene = "" ;
      scmdbuf = "" ;
      P004Y2_A263LegSexo = new byte[1] ;
      P004Y2_n263LegSexo = new boolean[] {false} ;
      P004Y2_A6LegNumero = new int[1] ;
      P004Y2_A1EmpCod = new short[1] ;
      P004Y2_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empleadosexo__default(),
         new Object[] {
             new Object[] {
            P004Y2_A263LegSexo, P004Y2_n263LegSexo, P004Y2_A6LegNumero, P004Y2_A1EmpCod, P004Y2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV13legSexo ;
   private byte AV20GXLvl14 ;
   private byte A263LegSexo ;
   private short AV16empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV15CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV12tiene ;
   private String scmdbuf ;
   private boolean n263LegSexo ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private byte[] P004Y2_A263LegSexo ;
   private boolean[] P004Y2_n263LegSexo ;
   private int[] P004Y2_A6LegNumero ;
   private short[] P004Y2_A1EmpCod ;
   private int[] P004Y2_A3CliCod ;
}

final  class empleadosexo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004Y2", "SELECT LegSexo, LegNumero, EmpCod, CliCod FROM Legajo WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (LegSexo = ?) ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
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
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               return;
      }
   }

}

