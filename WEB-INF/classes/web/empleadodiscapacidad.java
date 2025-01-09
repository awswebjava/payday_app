package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empleadodiscapacidad extends GXProcedure
{
   public empleadodiscapacidad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empleadodiscapacidad.class ), "" );
   }

   public empleadodiscapacidad( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      empleadodiscapacidad.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 )
   {
      empleadodiscapacidad.this.AV11CliCod = aP0;
      empleadodiscapacidad.this.AV12empcod = aP1;
      empleadodiscapacidad.this.AV8LegNumero = aP2;
      empleadodiscapacidad.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15GXLvl2 = (byte)(0) ;
      /* Using cursor P004S2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12empcod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A241LegDiscapacidad = P004S2_A241LegDiscapacidad[0] ;
         A6LegNumero = P004S2_A6LegNumero[0] ;
         A1EmpCod = P004S2_A1EmpCod[0] ;
         A3CliCod = P004S2_A3CliCod[0] ;
         AV15GXLvl2 = (byte)(1) ;
         AV10tieneDiscapacidad = "1" ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV15GXLvl2 == 0 )
      {
         AV10tieneDiscapacidad = "0" ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = empleadodiscapacidad.this.AV10tieneDiscapacidad;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10tieneDiscapacidad = "" ;
      scmdbuf = "" ;
      P004S2_A241LegDiscapacidad = new byte[1] ;
      P004S2_A6LegNumero = new int[1] ;
      P004S2_A1EmpCod = new short[1] ;
      P004S2_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empleadodiscapacidad__default(),
         new Object[] {
             new Object[] {
            P004S2_A241LegDiscapacidad, P004S2_A6LegNumero, P004S2_A1EmpCod, P004S2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV15GXLvl2 ;
   private byte A241LegDiscapacidad ;
   private short AV12empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV10tieneDiscapacidad ;
   private String scmdbuf ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private byte[] P004S2_A241LegDiscapacidad ;
   private int[] P004S2_A6LegNumero ;
   private short[] P004S2_A1EmpCod ;
   private int[] P004S2_A3CliCod ;
}

final  class empleadodiscapacidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004S2", "SELECT LegDiscapacidad, LegNumero, EmpCod, CliCod FROM Legajo WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (LegDiscapacidad = 1) ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

