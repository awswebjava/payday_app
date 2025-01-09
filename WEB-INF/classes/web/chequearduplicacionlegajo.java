package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class chequearduplicacionlegajo extends GXProcedure
{
   public chequearduplicacionlegajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( chequearduplicacionlegajo.class ), "" );
   }

   public chequearduplicacionlegajo( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<String> executeUdp( int aP0 ,
                                                 short aP1 ,
                                                 int aP2 ,
                                                 String aP3 ,
                                                 long aP4 )
   {
      chequearduplicacionlegajo.this.aP5 = new GXSimpleCollection[] {new GXSimpleCollection<String>(String.class, "internal", "")};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        long aP4 ,
                        GXSimpleCollection<String>[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             long aP4 ,
                             GXSimpleCollection<String>[] aP5 )
   {
      chequearduplicacionlegajo.this.AV13CliCod = aP0;
      chequearduplicacionlegajo.this.AV8EmpCod = aP1;
      chequearduplicacionlegajo.this.AV9LegNumero = aP2;
      chequearduplicacionlegajo.this.AV10LegId = aP3;
      chequearduplicacionlegajo.this.AV12LegCUIL = aP4;
      chequearduplicacionlegajo.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01JQ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P01JQ2_A6LegNumero[0] ;
         A1EmpCod = P01JQ2_A1EmpCod[0] ;
         A3CliCod = P01JQ2_A3CliCod[0] ;
         A93LegId = P01JQ2_A93LegId[0] ;
         n93LegId = P01JQ2_n93LegId[0] ;
         A591LegNomApe = P01JQ2_A591LegNomApe[0] ;
         A239LegCUIL = P01JQ2_A239LegCUIL[0] ;
         if ( GXutil.strcmp(GXutil.trim( GXutil.upper( AV10LegId)), GXutil.trim( GXutil.upper( A93LegId))) == 0 )
         {
            AV11errores.add(httpContext.getMessage( "Existe otro legajo con id ", "")+GXutil.trim( A93LegId)+" ("+GXutil.trim( A591LegNomApe)+")", 0);
         }
         if ( AV12LegCUIL == A239LegCUIL )
         {
            AV11errores.add(httpContext.getMessage( "Existe otro legajo con CUIL  ", "")+GXutil.trim( GXutil.trim( GXutil.str( A239LegCUIL, 11, 0)))+" ("+GXutil.trim( A591LegNomApe)+")", 0);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = chequearduplicacionlegajo.this.AV11errores;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11errores = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      P01JQ2_A6LegNumero = new int[1] ;
      P01JQ2_A1EmpCod = new short[1] ;
      P01JQ2_A3CliCod = new int[1] ;
      P01JQ2_A93LegId = new String[] {""} ;
      P01JQ2_n93LegId = new boolean[] {false} ;
      P01JQ2_A591LegNomApe = new String[] {""} ;
      P01JQ2_A239LegCUIL = new long[1] ;
      A93LegId = "" ;
      A591LegNomApe = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.chequearduplicacionlegajo__default(),
         new Object[] {
             new Object[] {
            P01JQ2_A6LegNumero, P01JQ2_A1EmpCod, P01JQ2_A3CliCod, P01JQ2_A93LegId, P01JQ2_n93LegId, P01JQ2_A591LegNomApe, P01JQ2_A239LegCUIL
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private long AV12LegCUIL ;
   private long A239LegCUIL ;
   private String AV10LegId ;
   private String scmdbuf ;
   private String A93LegId ;
   private boolean n93LegId ;
   private String A591LegNomApe ;
   private GXSimpleCollection<String>[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P01JQ2_A6LegNumero ;
   private short[] P01JQ2_A1EmpCod ;
   private int[] P01JQ2_A3CliCod ;
   private String[] P01JQ2_A93LegId ;
   private boolean[] P01JQ2_n93LegId ;
   private String[] P01JQ2_A591LegNomApe ;
   private long[] P01JQ2_A239LegCUIL ;
   private GXSimpleCollection<String> AV11errores ;
}

final  class chequearduplicacionlegajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01JQ2", "SELECT LegNumero, EmpCod, CliCod, LegId, LegNomApe, LegCUIL FROM Legajo WHERE (CliCod = ? and EmpCod = ?) AND (LegNumero <> ?) ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((long[]) buf[6])[0] = rslt.getLong(6);
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

