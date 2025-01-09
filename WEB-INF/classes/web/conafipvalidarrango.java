package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conafipvalidarrango extends GXProcedure
{
   public conafipvalidarrango( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conafipvalidarrango.class ), "" );
   }

   public conafipvalidarrango( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             int aP2 )
   {
      conafipvalidarrango.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        int aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             int aP2 ,
                             String[] aP3 )
   {
      conafipvalidarrango.this.AV8TipoConCod = aP0;
      conafipvalidarrango.this.AV9SubTipoConCod1 = aP1;
      conafipvalidarrango.this.AV12numero = aP2;
      conafipvalidarrango.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! (GXutil.strcmp("", AV9SubTipoConCod1)==0) )
      {
         /* Using cursor P00GC2 */
         pr_default.execute(0, new Object[] {AV8TipoConCod, AV9SubTipoConCod1});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A38SubTipoConCod1 = P00GC2_A38SubTipoConCod1[0] ;
            A37TipoConCod = P00GC2_A37TipoConCod[0] ;
            A375SubTRangoDesde = P00GC2_A375SubTRangoDesde[0] ;
            A376SubTRangoHasta = P00GC2_A376SubTRangoHasta[0] ;
            A378TRangoHasta = P00GC2_A378TRangoHasta[0] ;
            A377TRangoDesde = P00GC2_A377TRangoDesde[0] ;
            A378TRangoHasta = P00GC2_A378TRangoHasta[0] ;
            A377TRangoDesde = P00GC2_A377TRangoDesde[0] ;
            if ( ! (0==A375SubTRangoDesde) )
            {
               if ( ( AV12numero < A375SubTRangoDesde ) || ( AV12numero > A376SubTRangoHasta ) )
               {
                  AV15error = httpContext.getMessage( "El valor del Código AFIP debe estar entre ", "") + GXutil.trim( GXutil.str( A375SubTRangoDesde, 8, 0)) + httpContext.getMessage( " y ", "") + GXutil.trim( GXutil.str( A376SubTRangoHasta, 8, 0)) ;
               }
            }
            else
            {
               if ( ( AV12numero < A377TRangoDesde ) || ( AV12numero > A378TRangoHasta ) )
               {
                  AV15error = httpContext.getMessage( "El valor del Código AFIP debe estar entre ", "") + GXutil.trim( GXutil.str( A377TRangoDesde, 8, 0)) + httpContext.getMessage( " y ", "") + GXutil.trim( GXutil.str( A378TRangoHasta, 8, 0)) ;
               }
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
      }
      else
      {
         /* Using cursor P00GC3 */
         pr_default.execute(1, new Object[] {AV8TipoConCod});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A37TipoConCod = P00GC3_A37TipoConCod[0] ;
            A378TRangoHasta = P00GC3_A378TRangoHasta[0] ;
            A377TRangoDesde = P00GC3_A377TRangoDesde[0] ;
            if ( ( AV12numero < A377TRangoDesde ) || ( AV12numero > A378TRangoHasta ) )
            {
               AV15error = httpContext.getMessage( "El valor del Código AFIP debe estar entre ", "") + GXutil.trim( GXutil.str( A377TRangoDesde, 8, 0)) + httpContext.getMessage( " y ", "") + GXutil.trim( GXutil.str( A378TRangoHasta, 8, 0)) ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = conafipvalidarrango.this.AV15error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15error = "" ;
      scmdbuf = "" ;
      P00GC2_A38SubTipoConCod1 = new String[] {""} ;
      P00GC2_A37TipoConCod = new String[] {""} ;
      P00GC2_A375SubTRangoDesde = new int[1] ;
      P00GC2_A376SubTRangoHasta = new int[1] ;
      P00GC2_A378TRangoHasta = new int[1] ;
      P00GC2_A377TRangoDesde = new int[1] ;
      A38SubTipoConCod1 = "" ;
      A37TipoConCod = "" ;
      P00GC3_A37TipoConCod = new String[] {""} ;
      P00GC3_A378TRangoHasta = new int[1] ;
      P00GC3_A377TRangoDesde = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conafipvalidarrango__default(),
         new Object[] {
             new Object[] {
            P00GC2_A38SubTipoConCod1, P00GC2_A37TipoConCod, P00GC2_A375SubTRangoDesde, P00GC2_A376SubTRangoHasta, P00GC2_A378TRangoHasta, P00GC2_A377TRangoDesde
            }
            , new Object[] {
            P00GC3_A37TipoConCod, P00GC3_A378TRangoHasta, P00GC3_A377TRangoDesde
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV12numero ;
   private int A375SubTRangoDesde ;
   private int A376SubTRangoHasta ;
   private int A378TRangoHasta ;
   private int A377TRangoDesde ;
   private String AV8TipoConCod ;
   private String AV9SubTipoConCod1 ;
   private String scmdbuf ;
   private String A38SubTipoConCod1 ;
   private String A37TipoConCod ;
   private String AV15error ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P00GC2_A38SubTipoConCod1 ;
   private String[] P00GC2_A37TipoConCod ;
   private int[] P00GC2_A375SubTRangoDesde ;
   private int[] P00GC2_A376SubTRangoHasta ;
   private int[] P00GC2_A378TRangoHasta ;
   private int[] P00GC2_A377TRangoDesde ;
   private String[] P00GC3_A37TipoConCod ;
   private int[] P00GC3_A378TRangoHasta ;
   private int[] P00GC3_A377TRangoDesde ;
}

final  class conafipvalidarrango__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00GC2", "SELECT T1.SubTipoConCod1, T1.TipoConCod, T1.SubTRangoDesde, T1.SubTRangoHasta, T2.TRangoHasta, T2.TRangoDesde FROM (TipoDeConceptoSubtipo1 T1 INNER JOIN TipoDeConcepto T2 ON T2.TipoConCod = T1.TipoConCod) WHERE T1.TipoConCod = ( ?) and T1.SubTipoConCod1 = ( ?) ORDER BY T1.TipoConCod, T1.SubTipoConCod1 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00GC3", "SELECT TipoConCod, TRangoHasta, TRangoDesde FROM TipoDeConcepto WHERE TipoConCod = ( ?) ORDER BY TipoConCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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

