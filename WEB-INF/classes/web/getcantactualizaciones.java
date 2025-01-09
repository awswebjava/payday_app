package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcantactualizaciones extends GXProcedure
{
   public getcantactualizaciones( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcantactualizaciones.class ), "" );
   }

   public getcantactualizaciones( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 )
   {
      getcantactualizaciones.this.aP1 = new short[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        short[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             short[] aP1 )
   {
      getcantactualizaciones.this.AV8CliCod = aP0;
      getcantactualizaciones.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9Ahora = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      AV19Cliente_updatewwds_1_cliupdfecrel = AV10CliUpdFecRel ;
      AV20Cliente_updatewwds_2_cliupdrelhab = AV11CliUpdRelHab ;
      AV21Cliente_updatewwds_3_tfcliupdreldesc = "" ;
      AV22Cliente_updatewwds_4_tfcliupdreldesc_sels = AV12TFCliUpdRelDesc_Sels ;
      AV23Cliente_updatewwds_5_tfcliupddtapl = AV13TFCliUpdDTApl ;
      AV24Cliente_updatewwds_6_tfcliupddtapl_to = AV14TFCliUpdDTApl_To ;
      /* Optimized group. */
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1884CliUpdRelDesc ,
                                           AV22Cliente_updatewwds_4_tfcliupdreldesc_sels ,
                                           Integer.valueOf(AV22Cliente_updatewwds_4_tfcliupdreldesc_sels.size()) ,
                                           AV21Cliente_updatewwds_3_tfcliupdreldesc ,
                                           AV23Cliente_updatewwds_5_tfcliupddtapl ,
                                           AV24Cliente_updatewwds_6_tfcliupddtapl_to ,
                                           A1883CliUpdDTApl ,
                                           Integer.valueOf(AV8CliCod) ,
                                           A1962CliUpdFecRel } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.DATE
                                           }
      });
      lV21Cliente_updatewwds_3_tfcliupdreldesc = GXutil.concat( GXutil.rtrim( AV21Cliente_updatewwds_3_tfcliupdreldesc), "%", "") ;
      /* Using cursor P022V2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV9Ahora, lV21Cliente_updatewwds_3_tfcliupdreldesc, AV23Cliente_updatewwds_5_tfcliupddtapl, AV24Cliente_updatewwds_6_tfcliupddtapl_to});
      cV15count = P022V2_AV15count[0] ;
      pr_default.close(0);
      AV15count = (short)(AV15count+cV15count*1) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getcantactualizaciones.this.AV15count;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9Ahora = GXutil.resetTime( GXutil.nullDate() );
      AV19Cliente_updatewwds_1_cliupdfecrel = GXutil.resetTime( GXutil.nullDate() );
      AV10CliUpdFecRel = GXutil.resetTime( GXutil.nullDate() );
      AV21Cliente_updatewwds_3_tfcliupdreldesc = "" ;
      AV22Cliente_updatewwds_4_tfcliupdreldesc_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12TFCliUpdRelDesc_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23Cliente_updatewwds_5_tfcliupddtapl = GXutil.resetTime( GXutil.nullDate() );
      AV13TFCliUpdDTApl = GXutil.resetTime( GXutil.nullDate() );
      AV24Cliente_updatewwds_6_tfcliupddtapl_to = GXutil.resetTime( GXutil.nullDate() );
      AV14TFCliUpdDTApl_To = GXutil.resetTime( GXutil.nullDate() );
      scmdbuf = "" ;
      lV21Cliente_updatewwds_3_tfcliupdreldesc = "" ;
      A1884CliUpdRelDesc = "" ;
      A1883CliUpdDTApl = GXutil.resetTime( GXutil.nullDate() );
      A1962CliUpdFecRel = GXutil.resetTime( GXutil.nullDate() );
      P022V2_AV15count = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcantactualizaciones__default(),
         new Object[] {
             new Object[] {
            P022V2_AV15count
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV15count ;
   private short cV15count ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV22Cliente_updatewwds_4_tfcliupdreldesc_sels_size ;
   private String scmdbuf ;
   private java.util.Date AV9Ahora ;
   private java.util.Date AV19Cliente_updatewwds_1_cliupdfecrel ;
   private java.util.Date AV10CliUpdFecRel ;
   private java.util.Date AV23Cliente_updatewwds_5_tfcliupddtapl ;
   private java.util.Date AV13TFCliUpdDTApl ;
   private java.util.Date AV24Cliente_updatewwds_6_tfcliupddtapl_to ;
   private java.util.Date AV14TFCliUpdDTApl_To ;
   private java.util.Date A1883CliUpdDTApl ;
   private java.util.Date A1962CliUpdFecRel ;
   private boolean AV20Cliente_updatewwds_2_cliupdrelhab ;
   private boolean AV11CliUpdRelHab ;
   private String AV21Cliente_updatewwds_3_tfcliupdreldesc ;
   private String lV21Cliente_updatewwds_3_tfcliupdreldesc ;
   private String A1884CliUpdRelDesc ;
   private short[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P022V2_AV15count ;
   private GXSimpleCollection<String> AV22Cliente_updatewwds_4_tfcliupdreldesc_sels ;
   private GXSimpleCollection<String> AV12TFCliUpdRelDesc_Sels ;
}

final  class getcantactualizaciones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P022V2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1884CliUpdRelDesc ,
                                          GXSimpleCollection<String> AV22Cliente_updatewwds_4_tfcliupdreldesc_sels ,
                                          int AV22Cliente_updatewwds_4_tfcliupdreldesc_sels_size ,
                                          String AV21Cliente_updatewwds_3_tfcliupdreldesc ,
                                          java.util.Date AV23Cliente_updatewwds_5_tfcliupddtapl ,
                                          java.util.Date AV24Cliente_updatewwds_6_tfcliupddtapl_to ,
                                          java.util.Date A1883CliUpdDTApl ,
                                          int AV8CliCod ,
                                          java.util.Date A1962CliUpdFecRel )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[5];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM (Cliente_Update T1 INNER JOIN Cliente_Release T2 ON T2.CliCod = T1.CliUpdCliCod AND T2.CliRelSec = T1.CliUpdRelSec)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      addWhere(sWhereString, "(? >= T1.CliUpdFecRel)");
      addWhere(sWhereString, "((T1.CliUpdDTApl = DATE '00010101'))");
      addWhere(sWhereString, "(T2.CliReHabilitado = TRUE)");
      if ( ( AV22Cliente_updatewwds_4_tfcliupdreldesc_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV21Cliente_updatewwds_3_tfcliupdreldesc)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.CliUpdRelDesc) like LOWER(?))");
      }
      else
      {
         GXv_int1[2] = (byte)(1) ;
      }
      if ( AV22Cliente_updatewwds_4_tfcliupdreldesc_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV22Cliente_updatewwds_4_tfcliupdreldesc_sels, "T1.CliUpdRelDesc IN (", ")")+")");
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV23Cliente_updatewwds_5_tfcliupddtapl) )
      {
         addWhere(sWhereString, "(T1.CliUpdDTApl >= ?)");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.nullDate(), AV24Cliente_updatewwds_6_tfcliupddtapl_to) )
      {
         addWhere(sWhereString, "(T1.CliUpdDTApl <= ?)");
      }
      else
      {
         GXv_int1[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P022V2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , (java.util.Date)dynConstraints[4] , (java.util.Date)dynConstraints[5] , (java.util.Date)dynConstraints[6] , ((Number) dynConstraints[7]).intValue() , (java.util.Date)dynConstraints[8] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P022V2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[6], false, true);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[8], false);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDateTime(sIdx, (java.util.Date)parms[9], false);
               }
               return;
      }
   }

}

