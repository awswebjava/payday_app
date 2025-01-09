package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newobrasocial extends GXProcedure
{
   public newobrasocial( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newobrasocial.class ), "" );
   }

   public newobrasocial( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String aP3 ,
                        boolean aP4 ,
                        String aP5 ,
                        String aP6 ,
                        java.math.BigDecimal aP7 ,
                        String aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String aP3 ,
                             boolean aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.math.BigDecimal aP7 ,
                             String aP8 )
   {
      newobrasocial.this.AV12CliCod = aP0;
      newobrasocial.this.AV13OsoCod = aP1;
      newobrasocial.this.AV14OsoDescrip = aP2;
      newobrasocial.this.AV15OsoSigla = aP3;
      newobrasocial.this.AV11OsoHabilitada = aP4;
      newobrasocial.this.AV8OsoC3992 = aP5;
      newobrasocial.this.AV9OsoSiglaYDesc = aP6;
      newobrasocial.this.AV10OsoAporteAdic = aP7;
      newobrasocial.this.AV16OsoActCom = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE ObraSocial

      */
      A3CliCod = AV12CliCod ;
      A5OsoCod = GXutil.trim( AV13OsoCod) ;
      A307OsoDescrip = GXutil.trim( AV14OsoDescrip) ;
      A392OsoSigla = GXutil.trim( AV15OsoSigla) ;
      A308OsoHabilitada = AV11OsoHabilitada ;
      A306OsoC3992 = AV8OsoC3992 ;
      n306OsoC3992 = false ;
      A555OsoSiglaYDesc = AV9OsoSiglaYDesc ;
      GXt_char1 = A681OsoDescripSinAc ;
      GXv_char2[0] = GXt_char1 ;
      new web.sacaracentos2(remoteHandle, context).execute( A307OsoDescrip, GXv_char2) ;
      newobrasocial.this.GXt_char1 = GXv_char2[0] ;
      A681OsoDescripSinAc = GXutil.upper( GXt_char1) ;
      A893OsoAporteAdic = AV10OsoAporteAdic ;
      A1981OsoRelSec = 0 ;
      A1982OsoRelSecCli = 0 ;
      A1983OsoPadre = "" ;
      A2014OsoRelRef = "" ;
      A2035OsoOld = "" ;
      if ( ! (GXutil.strcmp("", AV16OsoActCom)==0) )
      {
         A2160OsoActCom = AV16OsoActCom ;
         n2160OsoActCom = false ;
      }
      else
      {
         A2160OsoActCom = "" ;
         n2160OsoActCom = false ;
         n2160OsoActCom = true ;
      }
      /* Using cursor P01WY2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A5OsoCod, A307OsoDescrip, A392OsoSigla, Boolean.valueOf(A308OsoHabilitada), Boolean.valueOf(n306OsoC3992), A306OsoC3992, A555OsoSiglaYDesc, A681OsoDescripSinAc, A893OsoAporteAdic, Integer.valueOf(A1981OsoRelSec), Integer.valueOf(A1982OsoRelSecCli), A1983OsoPadre, A2014OsoRelRef, A2035OsoOld, Boolean.valueOf(n2160OsoActCom), A2160OsoActCom});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("ObraSocial");
      if ( (pr_default.getStatus(0) == 1) )
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
      A5OsoCod = "" ;
      A307OsoDescrip = "" ;
      A392OsoSigla = "" ;
      A306OsoC3992 = "" ;
      A555OsoSiglaYDesc = "" ;
      A681OsoDescripSinAc = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      A893OsoAporteAdic = DecimalUtil.ZERO ;
      A1983OsoPadre = "" ;
      A2014OsoRelRef = "" ;
      A2035OsoOld = "" ;
      A2160OsoActCom = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newobrasocial__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV12CliCod ;
   private int GX_INS37 ;
   private int A3CliCod ;
   private int A1981OsoRelSec ;
   private int A1982OsoRelSecCli ;
   private java.math.BigDecimal AV10OsoAporteAdic ;
   private java.math.BigDecimal A893OsoAporteAdic ;
   private String AV13OsoCod ;
   private String AV15OsoSigla ;
   private String AV8OsoC3992 ;
   private String AV16OsoActCom ;
   private String A5OsoCod ;
   private String A392OsoSigla ;
   private String A306OsoC3992 ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String A1983OsoPadre ;
   private String A2160OsoActCom ;
   private String Gx_emsg ;
   private boolean AV11OsoHabilitada ;
   private boolean A308OsoHabilitada ;
   private boolean n306OsoC3992 ;
   private boolean n2160OsoActCom ;
   private String A2035OsoOld ;
   private String AV14OsoDescrip ;
   private String AV9OsoSiglaYDesc ;
   private String A307OsoDescrip ;
   private String A555OsoSiglaYDesc ;
   private String A681OsoDescripSinAc ;
   private String A2014OsoRelRef ;
   private IDataStoreProvider pr_default ;
}

final  class newobrasocial__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01WY2", "SAVEPOINT gxupdate;INSERT INTO ObraSocial(CliCod, OsoCod, OsoDescrip, OsoSigla, OsoHabilitada, OsoC3992, OsoSiglaYDesc, OsoDescripSinAc, OsoAporteAdic, OsoRelSec, OsoRelSecCli, OsoPadre, OsoRelRef, OsoOld, OsoActCom) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(6, (String)parms[6], 20);
               }
               stmt.setVarchar(7, (String)parms[7], 400, false);
               stmt.setVarchar(8, (String)parms[8], 400, false);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[9], 2);
               stmt.setInt(10, ((Number) parms[10]).intValue());
               stmt.setInt(11, ((Number) parms[11]).intValue());
               stmt.setString(12, (String)parms[12], 20);
               stmt.setVarchar(13, (String)parms[13], 40, false);
               stmt.setNLongVarchar(14, (String)parms[14], false);
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(15, (String)parms[16], 20);
               }
               return;
      }
   }

}

