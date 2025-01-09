package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importar_os extends GXProcedure
{
   public importar_os( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importar_os.class ), "" );
   }

   public importar_os( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        String aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             String aP2 )
   {
      importar_os.this.AV8Orig_CliCod = aP0;
      importar_os.this.AV10CliCod = aP1;
      importar_os.this.AV9OsoActCom = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, "1") ;
      /* Using cursor P023R2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8Orig_CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P023R2_A3CliCod[0] ;
         A5OsoCod = P023R2_A5OsoCod[0] ;
         A307OsoDescrip = P023R2_A307OsoDescrip[0] ;
         A392OsoSigla = P023R2_A392OsoSigla[0] ;
         A308OsoHabilitada = P023R2_A308OsoHabilitada[0] ;
         A306OsoC3992 = P023R2_A306OsoC3992[0] ;
         n306OsoC3992 = P023R2_n306OsoC3992[0] ;
         A555OsoSiglaYDesc = P023R2_A555OsoSiglaYDesc[0] ;
         A893OsoAporteAdic = P023R2_A893OsoAporteAdic[0] ;
         A2160OsoActCom = P023R2_A2160OsoActCom[0] ;
         n2160OsoActCom = P023R2_n2160OsoActCom[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV13Pgmname, httpContext.getMessage( "alta ", "")+GXutil.trim( A5OsoCod)) ;
         new web.newobrasocial(remoteHandle, context).execute( AV10CliCod, A5OsoCod, A307OsoDescrip, A392OsoSigla, A308OsoHabilitada, A306OsoC3992, A555OsoSiglaYDesc, A893OsoAporteAdic, A2160OsoActCom) ;
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
      AV13Pgmname = "" ;
      scmdbuf = "" ;
      P023R2_A3CliCod = new int[1] ;
      P023R2_A5OsoCod = new String[] {""} ;
      P023R2_A307OsoDescrip = new String[] {""} ;
      P023R2_A392OsoSigla = new String[] {""} ;
      P023R2_A308OsoHabilitada = new boolean[] {false} ;
      P023R2_A306OsoC3992 = new String[] {""} ;
      P023R2_n306OsoC3992 = new boolean[] {false} ;
      P023R2_A555OsoSiglaYDesc = new String[] {""} ;
      P023R2_A893OsoAporteAdic = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P023R2_A2160OsoActCom = new String[] {""} ;
      P023R2_n2160OsoActCom = new boolean[] {false} ;
      A5OsoCod = "" ;
      A307OsoDescrip = "" ;
      A392OsoSigla = "" ;
      A306OsoC3992 = "" ;
      A555OsoSiglaYDesc = "" ;
      A893OsoAporteAdic = DecimalUtil.ZERO ;
      A2160OsoActCom = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importar_os__default(),
         new Object[] {
             new Object[] {
            P023R2_A3CliCod, P023R2_A5OsoCod, P023R2_A307OsoDescrip, P023R2_A392OsoSigla, P023R2_A308OsoHabilitada, P023R2_A306OsoC3992, P023R2_n306OsoC3992, P023R2_A555OsoSiglaYDesc, P023R2_A893OsoAporteAdic, P023R2_A2160OsoActCom,
            P023R2_n2160OsoActCom
            }
         }
      );
      AV13Pgmname = "importar_os" ;
      /* GeneXus formulas. */
      AV13Pgmname = "importar_os" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8Orig_CliCod ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private java.math.BigDecimal A893OsoAporteAdic ;
   private String AV9OsoActCom ;
   private String AV13Pgmname ;
   private String scmdbuf ;
   private String A5OsoCod ;
   private String A392OsoSigla ;
   private String A306OsoC3992 ;
   private String A2160OsoActCom ;
   private boolean A308OsoHabilitada ;
   private boolean n306OsoC3992 ;
   private boolean n2160OsoActCom ;
   private String A307OsoDescrip ;
   private String A555OsoSiglaYDesc ;
   private IDataStoreProvider pr_default ;
   private int[] P023R2_A3CliCod ;
   private String[] P023R2_A5OsoCod ;
   private String[] P023R2_A307OsoDescrip ;
   private String[] P023R2_A392OsoSigla ;
   private boolean[] P023R2_A308OsoHabilitada ;
   private String[] P023R2_A306OsoC3992 ;
   private boolean[] P023R2_n306OsoC3992 ;
   private String[] P023R2_A555OsoSiglaYDesc ;
   private java.math.BigDecimal[] P023R2_A893OsoAporteAdic ;
   private String[] P023R2_A2160OsoActCom ;
   private boolean[] P023R2_n2160OsoActCom ;
}

final  class importar_os__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P023R2", "SELECT CliCod, OsoCod, OsoDescrip, OsoSigla, OsoHabilitada, OsoC3992, OsoSiglaYDesc, OsoAporteAdic, OsoActCom FROM ObraSocial WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[9])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
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

