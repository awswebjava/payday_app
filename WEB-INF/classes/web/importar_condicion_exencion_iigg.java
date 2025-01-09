package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importar_condicion_exencion_iigg extends GXProcedure
{
   public importar_condicion_exencion_iigg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importar_condicion_exencion_iigg.class ), "" );
   }

   public importar_condicion_exencion_iigg( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        int aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             int aP1 )
   {
      importar_condicion_exencion_iigg.this.AV9Orig_CliCod = aP0;
      importar_condicion_exencion_iigg.this.AV8CliCod = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01702 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9Orig_CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01702_A3CliCod[0] ;
         A1105CondExenIIGG = P01702_A1105CondExenIIGG[0] ;
         A1104CondExenIIGGCon = P01702_A1104CondExenIIGGCon[0] ;
         A1106CondExenIIGGAcu = P01702_A1106CondExenIIGGAcu[0] ;
         A1107CondExenIIGGProm = P01702_A1107CondExenIIGGProm[0] ;
         A1123CondExenIIGGVar = P01702_A1123CondExenIIGGVar[0] ;
         n1123CondExenIIGGVar = P01702_n1123CondExenIIGGVar[0] ;
         A1108CondexenIIGGNom = P01702_A1108CondexenIIGGNom[0] ;
         A2237CondExenIIGGVFi = P01702_A2237CondExenIIGGVFi[0] ;
         A2238CondExenIIGGOpe = P01702_A2238CondExenIIGGOpe[0] ;
         new web.new_condicion_exencion_iigg(remoteHandle, context).execute( AV8CliCod, A1105CondExenIIGG, A1104CondExenIIGGCon, A1106CondExenIIGGAcu, A1107CondExenIIGGProm, A1123CondExenIIGGVar, A1108CondexenIIGGNom, A2237CondExenIIGGVFi, A2238CondExenIIGGOpe) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
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
      P01702_A3CliCod = new int[1] ;
      P01702_A1105CondExenIIGG = new String[] {""} ;
      P01702_A1104CondExenIIGGCon = new String[] {""} ;
      P01702_A1106CondExenIIGGAcu = new boolean[] {false} ;
      P01702_A1107CondExenIIGGProm = new boolean[] {false} ;
      P01702_A1123CondExenIIGGVar = new String[] {""} ;
      P01702_n1123CondExenIIGGVar = new boolean[] {false} ;
      P01702_A1108CondexenIIGGNom = new String[] {""} ;
      P01702_A2237CondExenIIGGVFi = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01702_A2238CondExenIIGGOpe = new String[] {""} ;
      A1105CondExenIIGG = "" ;
      A1104CondExenIIGGCon = "" ;
      A1123CondExenIIGGVar = "" ;
      A1108CondexenIIGGNom = "" ;
      A2237CondExenIIGGVFi = DecimalUtil.ZERO ;
      A2238CondExenIIGGOpe = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importar_condicion_exencion_iigg__default(),
         new Object[] {
             new Object[] {
            P01702_A3CliCod, P01702_A1105CondExenIIGG, P01702_A1104CondExenIIGGCon, P01702_A1106CondExenIIGGAcu, P01702_A1107CondExenIIGGProm, P01702_A1123CondExenIIGGVar, P01702_n1123CondExenIIGGVar, P01702_A1108CondexenIIGGNom, P01702_A2237CondExenIIGGVFi, P01702_A2238CondExenIIGGOpe
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9Orig_CliCod ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private java.math.BigDecimal A2237CondExenIIGGVFi ;
   private String scmdbuf ;
   private String A1105CondExenIIGG ;
   private String A1104CondExenIIGGCon ;
   private String A1123CondExenIIGGVar ;
   private String A2238CondExenIIGGOpe ;
   private boolean A1106CondExenIIGGAcu ;
   private boolean A1107CondExenIIGGProm ;
   private boolean n1123CondExenIIGGVar ;
   private String A1108CondexenIIGGNom ;
   private IDataStoreProvider pr_default ;
   private int[] P01702_A3CliCod ;
   private String[] P01702_A1105CondExenIIGG ;
   private String[] P01702_A1104CondExenIIGGCon ;
   private boolean[] P01702_A1106CondExenIIGGAcu ;
   private boolean[] P01702_A1107CondExenIIGGProm ;
   private String[] P01702_A1123CondExenIIGGVar ;
   private boolean[] P01702_n1123CondExenIIGGVar ;
   private String[] P01702_A1108CondexenIIGGNom ;
   private java.math.BigDecimal[] P01702_A2237CondExenIIGGVFi ;
   private String[] P01702_A2238CondExenIIGGOpe ;
}

final  class importar_condicion_exencion_iigg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01702", "SELECT CliCod, CondExenIIGG, CondExenIIGGCon, CondExenIIGGAcu, CondExenIIGGProm, CondExenIIGGVar, CondexenIIGGNom, CondExenIIGGVFi, CondExenIIGGOpe FROM condicion_exencion_iigg WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[9])[0] = rslt.getString(9, 20);
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
      }
   }

}

