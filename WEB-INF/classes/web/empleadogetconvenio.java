package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empleadogetconvenio extends GXProcedure
{
   public empleadogetconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empleadogetconvenio.class ), "" );
   }

   public empleadogetconvenio( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      empleadogetconvenio.this.aP3 = new String[] {""};
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
      empleadogetconvenio.this.AV11CliCod = aP0;
      empleadogetconvenio.this.AV12empcod = aP1;
      empleadogetconvenio.this.AV8LegNumero = aP2;
      empleadogetconvenio.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00CT2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12empcod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P00CT2_A6LegNumero[0] ;
         A1EmpCod = P00CT2_A1EmpCod[0] ;
         A3CliCod = P00CT2_A3CliCod[0] ;
         A937LegConveCodigo = P00CT2_A937LegConveCodigo[0] ;
         n937LegConveCodigo = P00CT2_n937LegConveCodigo[0] ;
         AV10ConveCodigo = A937LegConveCodigo ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( false )
      {
         new web.pruebaharcode(remoteHandle, context).execute( ) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = empleadogetconvenio.this.AV10ConveCodigo;
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
      P00CT2_A6LegNumero = new int[1] ;
      P00CT2_A1EmpCod = new short[1] ;
      P00CT2_A3CliCod = new int[1] ;
      P00CT2_A937LegConveCodigo = new String[] {""} ;
      P00CT2_n937LegConveCodigo = new boolean[] {false} ;
      A937LegConveCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empleadogetconvenio__default(),
         new Object[] {
             new Object[] {
            P00CT2_A6LegNumero, P00CT2_A1EmpCod, P00CT2_A3CliCod, P00CT2_A937LegConveCodigo, P00CT2_n937LegConveCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV10ConveCodigo ;
   private String scmdbuf ;
   private String A937LegConveCodigo ;
   private boolean n937LegConveCodigo ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P00CT2_A6LegNumero ;
   private short[] P00CT2_A1EmpCod ;
   private int[] P00CT2_A3CliCod ;
   private String[] P00CT2_A937LegConveCodigo ;
   private boolean[] P00CT2_n937LegConveCodigo ;
}

final  class empleadogetconvenio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00CT2", "SELECT LegNumero, EmpCod, CliCod, LegConveCodigo FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

