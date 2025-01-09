package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empleadogetconvenio2 extends GXProcedure
{
   public empleadogetconvenio2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empleadogetconvenio2.class ), "" );
   }

   public empleadogetconvenio2( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            String[] aP3 )
   {
      empleadogetconvenio2.this.aP4 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 ,
                        short[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 ,
                             short[] aP4 )
   {
      empleadogetconvenio2.this.AV11CliCod = aP0;
      empleadogetconvenio2.this.AV12empcod = aP1;
      empleadogetconvenio2.this.AV8LegNumero = aP2;
      empleadogetconvenio2.this.aP3 = aP3;
      empleadogetconvenio2.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01872 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12empcod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P01872_A6LegNumero[0] ;
         A1EmpCod = P01872_A1EmpCod[0] ;
         A3CliCod = P01872_A3CliCod[0] ;
         A937LegConveCodigo = P01872_A937LegConveCodigo[0] ;
         n937LegConveCodigo = P01872_n937LegConveCodigo[0] ;
         A22LegPaiCod = P01872_A22LegPaiCod[0] ;
         n22LegPaiCod = P01872_n22LegPaiCod[0] ;
         AV10ConveCodigo = A937LegConveCodigo ;
         AV13LegPaiCod = A22LegPaiCod ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      new web.pruebaharcode(remoteHandle, context).execute( ) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = empleadogetconvenio2.this.AV10ConveCodigo;
      this.aP4[0] = empleadogetconvenio2.this.AV13LegPaiCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ConveCodigo = "" ;
      scmdbuf = "" ;
      P01872_A6LegNumero = new int[1] ;
      P01872_A1EmpCod = new short[1] ;
      P01872_A3CliCod = new int[1] ;
      P01872_A937LegConveCodigo = new String[] {""} ;
      P01872_n937LegConveCodigo = new boolean[] {false} ;
      P01872_A22LegPaiCod = new short[1] ;
      P01872_n22LegPaiCod = new boolean[] {false} ;
      A937LegConveCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empleadogetconvenio2__default(),
         new Object[] {
             new Object[] {
            P01872_A6LegNumero, P01872_A1EmpCod, P01872_A3CliCod, P01872_A937LegConveCodigo, P01872_n937LegConveCodigo, P01872_A22LegPaiCod, P01872_n22LegPaiCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12empcod ;
   private short AV13LegPaiCod ;
   private short A1EmpCod ;
   private short A22LegPaiCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV10ConveCodigo ;
   private String scmdbuf ;
   private String A937LegConveCodigo ;
   private boolean n937LegConveCodigo ;
   private boolean n22LegPaiCod ;
   private short[] aP4 ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P01872_A6LegNumero ;
   private short[] P01872_A1EmpCod ;
   private int[] P01872_A3CliCod ;
   private String[] P01872_A937LegConveCodigo ;
   private boolean[] P01872_n937LegConveCodigo ;
   private short[] P01872_A22LegPaiCod ;
   private boolean[] P01872_n22LegPaiCod ;
}

final  class empleadogetconvenio2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01872", "SELECT LegNumero, EmpCod, CliCod, LegConveCodigo, LegPaiCod FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
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

