package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conafipgetinvitemessage extends GXProcedure
{
   public conafipgetinvitemessage( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conafipgetinvitemessage.class ), "" );
   }

   public conafipgetinvitemessage( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 )
   {
      conafipgetinvitemessage.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      conafipgetinvitemessage.this.AV8TipoConCod = aP0;
      conafipgetinvitemessage.this.AV9SubTipoConCod1 = aP1;
      conafipgetinvitemessage.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (GXutil.strcmp("", AV9SubTipoConCod1)==0) )
      {
         /* Using cursor P00G52 */
         pr_default.execute(0, new Object[] {AV8TipoConCod, AV9SubTipoConCod1});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A38SubTipoConCod1 = P00G52_A38SubTipoConCod1[0] ;
            A37TipoConCod = P00G52_A37TipoConCod[0] ;
            A375SubTRangoDesde = P00G52_A375SubTRangoDesde[0] ;
            A376SubTRangoHasta = P00G52_A376SubTRangoHasta[0] ;
            A378TRangoHasta = P00G52_A378TRangoHasta[0] ;
            A377TRangoDesde = P00G52_A377TRangoDesde[0] ;
            A378TRangoHasta = P00G52_A378TRangoHasta[0] ;
            A377TRangoDesde = P00G52_A377TRangoDesde[0] ;
            AV10mensaje = httpContext.getMessage( "Desde ", "") ;
            if ( ! (0==A375SubTRangoDesde) )
            {
               AV10mensaje += GXutil.trim( GXutil.str( A375SubTRangoDesde, 8, 0)) + httpContext.getMessage( " a ", "") + GXutil.trim( GXutil.str( A376SubTRangoHasta, 8, 0)) ;
            }
            else
            {
               AV10mensaje += GXutil.trim( GXutil.str( A377TRangoDesde, 8, 0)) + httpContext.getMessage( " a ", "") + GXutil.trim( GXutil.str( A378TRangoHasta, 8, 0)) ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
      }
      else
      {
         /* Using cursor P00G53 */
         pr_default.execute(1, new Object[] {AV8TipoConCod});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A37TipoConCod = P00G53_A37TipoConCod[0] ;
            A378TRangoHasta = P00G53_A378TRangoHasta[0] ;
            A377TRangoDesde = P00G53_A377TRangoDesde[0] ;
            AV10mensaje = httpContext.getMessage( "Desde ", "") ;
            AV10mensaje += GXutil.trim( GXutil.str( A377TRangoDesde, 8, 0)) + httpContext.getMessage( " a ", "") + GXutil.trim( GXutil.str( A378TRangoHasta, 8, 0)) ;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = conafipgetinvitemessage.this.AV10mensaje;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10mensaje = "" ;
      scmdbuf = "" ;
      P00G52_A38SubTipoConCod1 = new String[] {""} ;
      P00G52_A37TipoConCod = new String[] {""} ;
      P00G52_A375SubTRangoDesde = new int[1] ;
      P00G52_A376SubTRangoHasta = new int[1] ;
      P00G52_A378TRangoHasta = new int[1] ;
      P00G52_A377TRangoDesde = new int[1] ;
      A38SubTipoConCod1 = "" ;
      A37TipoConCod = "" ;
      P00G53_A37TipoConCod = new String[] {""} ;
      P00G53_A378TRangoHasta = new int[1] ;
      P00G53_A377TRangoDesde = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conafipgetinvitemessage__default(),
         new Object[] {
             new Object[] {
            P00G52_A38SubTipoConCod1, P00G52_A37TipoConCod, P00G52_A375SubTRangoDesde, P00G52_A376SubTRangoHasta, P00G52_A378TRangoHasta, P00G52_A377TRangoDesde
            }
            , new Object[] {
            P00G53_A37TipoConCod, P00G53_A378TRangoHasta, P00G53_A377TRangoDesde
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int A375SubTRangoDesde ;
   private int A376SubTRangoHasta ;
   private int A378TRangoHasta ;
   private int A377TRangoDesde ;
   private String AV8TipoConCod ;
   private String AV9SubTipoConCod1 ;
   private String scmdbuf ;
   private String A38SubTipoConCod1 ;
   private String A37TipoConCod ;
   private String AV10mensaje ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00G52_A38SubTipoConCod1 ;
   private String[] P00G52_A37TipoConCod ;
   private int[] P00G52_A375SubTRangoDesde ;
   private int[] P00G52_A376SubTRangoHasta ;
   private int[] P00G52_A378TRangoHasta ;
   private int[] P00G52_A377TRangoDesde ;
   private String[] P00G53_A37TipoConCod ;
   private int[] P00G53_A378TRangoHasta ;
   private int[] P00G53_A377TRangoDesde ;
}

final  class conafipgetinvitemessage__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00G52", "SELECT T1.SubTipoConCod1, T1.TipoConCod, T1.SubTRangoDesde, T1.SubTRangoHasta, T2.TRangoHasta, T2.TRangoDesde FROM (TipoDeConceptoSubtipo1 T1 INNER JOIN TipoDeConcepto T2 ON T2.TipoConCod = T1.TipoConCod) WHERE T1.TipoConCod = ( ?) and T1.SubTipoConCod1 = ( ?) ORDER BY T1.TipoConCod, T1.SubTipoConCod1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00G53", "SELECT TipoConCod, TRangoHasta, TRangoDesde FROM TipoDeConcepto WHERE TipoConCod = ( ?) ORDER BY TipoConCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
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
               stmt.setString(1, (String)parms[0], 20);
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

