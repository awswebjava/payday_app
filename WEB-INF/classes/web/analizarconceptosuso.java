package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class analizarconceptosuso extends GXProcedure
{
   public analizarconceptosuso( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( analizarconceptosuso.class ), "" );
   }

   public analizarconceptosuso( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              String aP4 ,
                              String aP5 ,
                              String aP6 ,
                              boolean aP7 ,
                              boolean aP8 ,
                              boolean aP9 ,
                              boolean[] aP10 ,
                              boolean[] aP11 ,
                              GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem>[] aP12 )
   {
      analizarconceptosuso.this.aP13 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        boolean aP7 ,
                        boolean aP8 ,
                        boolean aP9 ,
                        boolean[] aP10 ,
                        boolean[] aP11 ,
                        GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem>[] aP12 ,
                        boolean[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             boolean aP8 ,
                             boolean aP9 ,
                             boolean[] aP10 ,
                             boolean[] aP11 ,
                             GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem>[] aP12 ,
                             boolean[] aP13 )
   {
      analizarconceptosuso.this.AV32CliCod = aP0;
      analizarconceptosuso.this.AV18EmpCod = aP1;
      analizarconceptosuso.this.AV20LiqNro = aP2;
      analizarconceptosuso.this.AV19LegNumero = aP3;
      analizarconceptosuso.this.AV23parm_ConCodigo = aP4;
      analizarconceptosuso.this.AV44TipoConCod = aP5;
      analizarconceptosuso.this.AV42ConsiderarSolo_parm = aP6;
      analizarconceptosuso.this.AV35devolverQuienesLoUsan = aP7;
      analizarconceptosuso.this.AV36indirectos = aP8;
      analizarconceptosuso.this.AV40analizarseASiMismo = aP9;
      analizarconceptosuso.this.aP10 = aP10;
      analizarconceptosuso.this.aP11 = aP11;
      analizarconceptosuso.this.aP12 = aP12;
      analizarconceptosuso.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV34ConsiderarSolo = AV42ConsiderarSolo_parm ;
      AV31seUsa = false ;
      AV21ConCodigo = GXutil.upper( AV23parm_ConCodigo) ;
      AV25sdt_conceptos.clear();
      AV39LosQueLosUsanNoExisten = true ;
      GXv_char1[0] = AV33concepto ;
      new web.codigoconcepto(remoteHandle, context).execute( AV32CliCod, true, GXv_char1) ;
      analizarconceptosuso.this.AV33concepto = GXv_char1[0] ;
      if ( GXutil.strcmp(AV23parm_ConCodigo, httpContext.getMessage( "CAL039", "")) == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV47Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV32CliCod, 6, 0))+" "+GXutil.trim( AV33concepto)+" "+GXutil.trim( AV21ConCodigo)) ;
      }
      if ( AV40analizarseASiMismo )
      {
         AV41vuelta = (short)(1) ;
      }
      else
      {
         AV41vuelta = (short)(2) ;
      }
      while ( true )
      {
         gxexitloop = false ;
         if ( gxexitloop )
         {
            break;
         }
         AV48GXLvl32 = (byte)(0) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              Short.valueOf(AV41vuelta) ,
                                              AV44TipoConCod ,
                                              A26ConCodigo ,
                                              AV23parm_ConCodigo ,
                                              A37TipoConCod ,
                                              Integer.valueOf(AV32CliCod) ,
                                              Integer.valueOf(A3CliCod) } ,
                                              new int[]{
                                              TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         /* Using cursor P00AQ2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV32CliCod), AV23parm_ConCodigo, AV23parm_ConCodigo, AV44TipoConCod});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A37TipoConCod = P00AQ2_A37TipoConCod[0] ;
            A26ConCodigo = P00AQ2_A26ConCodigo[0] ;
            A3CliCod = P00AQ2_A3CliCod[0] ;
            A148ConFormula = P00AQ2_A148ConFormula[0] ;
            n148ConFormula = P00AQ2_n148ConFormula[0] ;
            A41ConDescrip = P00AQ2_A41ConDescrip[0] ;
            AV48GXLvl32 = (byte)(1) ;
            if ( ( AV41vuelta == 1 ) || ( ( GXutil.strSearch( GXutil.upper( A148ConFormula), GXutil.trim( AV33concepto)+" "+GXutil.trim( AV21ConCodigo), 1) != 0 ) ) )
            {
               if ( GXutil.strcmp(AV23parm_ConCodigo, httpContext.getMessage( "CAL039", "")) == 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV47Pgmname, httpContext.getMessage( "entra a evaluar ", "")+A26ConCodigo) ;
               }
               AV26yaEsta = false ;
               AV49GXV1 = 1 ;
               while ( AV49GXV1 <= AV25sdt_conceptos.size() )
               {
                  AV24itemConcepto = (web.Sdtsdt_conceptos_sdt_conceptosItem)((web.Sdtsdt_conceptos_sdt_conceptosItem)AV25sdt_conceptos.elementAt(-1+AV49GXV1));
                  if ( GXutil.strcmp(AV24itemConcepto.getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo(), A26ConCodigo) == 0 )
                  {
                     AV26yaEsta = true ;
                     if (true) break;
                  }
                  AV49GXV1 = (int)(AV49GXV1+1) ;
               }
               if ( GXutil.strcmp(AV23parm_ConCodigo, httpContext.getMessage( "CAL039", "")) == 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV47Pgmname, httpContext.getMessage( "ya esta ", "")+GXutil.trim( GXutil.booltostr( AV26yaEsta))) ;
               }
               if ( ! AV26yaEsta )
               {
                  GXt_boolean2 = AV29esConceptoImprimible ;
                  GXv_boolean3[0] = GXt_boolean2 ;
                  new web.esconceptoimprimible(remoteHandle, context).execute( A37TipoConCod, GXv_boolean3) ;
                  analizarconceptosuso.this.GXt_boolean2 = GXv_boolean3[0] ;
                  AV29esConceptoImprimible = GXt_boolean2 ;
                  AV24itemConcepto = (web.Sdtsdt_conceptos_sdt_conceptosItem)new web.Sdtsdt_conceptos_sdt_conceptosItem(remoteHandle, context);
                  AV24itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo( A26ConCodigo );
                  AV24itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip( A41ConDescrip );
                  AV24itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esconcepto( true );
                  AV24itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esimprimible( AV29esConceptoImprimible );
                  if ( GXutil.strcmp(AV21ConCodigo, A26ConCodigo) == 0 )
                  {
                     AV24itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido( true );
                  }
                  else
                  {
                     AV24itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido( false );
                  }
                  AV25sdt_conceptos.add(AV24itemConcepto, 0);
                  if ( GXutil.strcmp(AV23parm_ConCodigo, httpContext.getMessage( "CAL039", "")) == 0 )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV47Pgmname, httpContext.getMessage( "concodigo ", "")+GXutil.trim( A26ConCodigo)+httpContext.getMessage( " &esConceptoImprimible", "")+GXutil.trim( GXutil.booltostr( AV29esConceptoImprimible))) ;
                  }
                  if ( AV29esConceptoImprimible )
                  {
                     if ( (0==AV19LegNumero) )
                     {
                        AV31seUsa = true ;
                        if ( ! AV35devolverQuienesLoUsan )
                        {
                           pr_default.close(0);
                           returnInSub = true;
                           cleanup();
                           if (true) return;
                        }
                     }
                     else
                     {
                        if ( ! (0==AV20LiqNro) )
                        {
                           GXv_decimal4[0] = AV30LiqDImpCalcu ;
                           GXv_boolean3[0] = AV38existe ;
                           GXv_int5[0] = (byte)((byte)((false)?1:0)) ;
                           new web.getliqdimpcalcu(remoteHandle, context).execute( AV32CliCod, AV18EmpCod, AV20LiqNro, AV19LegNumero, A26ConCodigo, "Calculo", true, GXv_decimal4, GXv_boolean3, GXv_int5) ;
                           analizarconceptosuso.this.AV30LiqDImpCalcu = GXv_decimal4[0] ;
                           analizarconceptosuso.this.AV38existe = GXv_boolean3[0] ;
                           if ( AV38existe )
                           {
                              AV39LosQueLosUsanNoExisten = false ;
                           }
                        }
                        else
                        {
                           AV38existe = true ;
                           AV30LiqDImpCalcu = DecimalUtil.doubleToDec(1) ;
                        }
                        if ( GXutil.strcmp(AV23parm_ConCodigo, httpContext.getMessage( "CAL039", "")) == 0 )
                        {
                           new web.msgdebug_prod(remoteHandle, context).execute( AV47Pgmname, httpContext.getMessage( "&LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV30LiqDImpCalcu, 14, 2))+httpContext.getMessage( " &ConsiderarSolo ", "")+AV34ConsiderarSolo+httpContext.getMessage( " existe ", "")+GXutil.trim( GXutil.booltostr( AV38existe))) ;
                        }
                        if ( ( AV38existe ) && ( ( ( AV30LiqDImpCalcu.doubleValue() > 0 ) && ( GXutil.strcmp(AV34ConsiderarSolo, httpContext.getMessage( "MAYORES A CERO", "")) == 0 ) ) || ( ( AV30LiqDImpCalcu.doubleValue() != 0 ) && ( GXutil.strcmp(AV34ConsiderarSolo, httpContext.getMessage( "DISTINTOS A CERO", "")) == 0 ) ) || ( GXutil.strcmp(AV34ConsiderarSolo, httpContext.getMessage( "TODOS", "")) == 0 ) ) )
                        {
                           AV31seUsa = true ;
                           if ( AV30LiqDImpCalcu.doubleValue() <= 0 )
                           {
                              AV37seUsaPeroEsCero = true ;
                           }
                           if ( GXutil.strcmp(AV23parm_ConCodigo, httpContext.getMessage( "CAL039", "")) == 0 )
                           {
                              new web.msgdebug_prod(remoteHandle, context).execute( AV47Pgmname, httpContext.getMessage( "se usa , &seUsaPeroEsCero ", "")+GXutil.trim( GXutil.booltostr( AV37seUsaPeroEsCero))) ;
                           }
                           if ( ! AV35devolverQuienesLoUsan )
                           {
                              pr_default.close(0);
                              returnInSub = true;
                              cleanup();
                              if (true) return;
                           }
                        }
                     }
                  }
                  else
                  {
                     if ( ( AV40analizarseASiMismo ) && ! AV36indirectos )
                     {
                        if ( ! (0==AV20LiqNro) )
                        {
                           GXv_decimal4[0] = AV30LiqDImpCalcu ;
                           GXv_boolean3[0] = AV38existe ;
                           GXv_int5[0] = (byte)((byte)((false)?1:0)) ;
                           new web.getliqdimpcalcu(remoteHandle, context).execute( AV32CliCod, AV18EmpCod, AV20LiqNro, AV19LegNumero, A26ConCodigo, "Calculo", true, GXv_decimal4, GXv_boolean3, GXv_int5) ;
                           analizarconceptosuso.this.AV30LiqDImpCalcu = GXv_decimal4[0] ;
                           analizarconceptosuso.this.AV38existe = GXv_boolean3[0] ;
                           if ( AV30LiqDImpCalcu.doubleValue() > 0 )
                           {
                              AV31seUsa = true ;
                           }
                        }
                        else
                        {
                           AV38existe = (boolean)((1==0)?false:true) ;
                           AV30LiqDImpCalcu = DecimalUtil.doubleToDec(1) ;
                        }
                     }
                  }
               }
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV48GXLvl32 == 0 )
         {
            if ( GXutil.strcmp(AV23parm_ConCodigo, httpContext.getMessage( "CAL039", "")) == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV47Pgmname, httpContext.getMessage( "none", "")) ;
            }
         }
         if ( ! AV36indirectos )
         {
            if (true) break;
         }
         else
         {
            if ( AV25sdt_conceptos.size() == 0 )
            {
               if (true) break;
            }
            else
            {
               AV27cntYaRecorridos = (short)(0) ;
               AV21ConCodigo = "" ;
               AV50GXV2 = 1 ;
               while ( AV50GXV2 <= AV25sdt_conceptos.size() )
               {
                  AV24itemConcepto = (web.Sdtsdt_conceptos_sdt_conceptosItem)((web.Sdtsdt_conceptos_sdt_conceptosItem)AV25sdt_conceptos.elementAt(-1+AV50GXV2));
                  if ( ! AV24itemConcepto.getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido() )
                  {
                     if ( (GXutil.strcmp("", AV21ConCodigo)==0) )
                     {
                        AV21ConCodigo = AV24itemConcepto.getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo() ;
                        AV24itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Yarecorrido( true );
                     }
                  }
                  else
                  {
                     AV27cntYaRecorridos = (short)(AV27cntYaRecorridos+1) ;
                  }
                  AV50GXV2 = (int)(AV50GXV2+1) ;
               }
               if ( GXutil.strcmp(AV23parm_ConCodigo, httpContext.getMessage( "CAL039", "")) == 0 )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV47Pgmname, httpContext.getMessage( "&cntYaRecorridos ", "")+GXutil.trim( GXutil.str( AV27cntYaRecorridos, 4, 0))) ;
               }
               if ( AV27cntYaRecorridos == AV25sdt_conceptos.size() )
               {
                  if (true) break;
               }
            }
         }
         if ( AV28i == 100000 )
         {
            if ( GXutil.strcmp(AV23parm_ConCodigo, httpContext.getMessage( "CAL039", "")) == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV47Pgmname, httpContext.getMessage( "loop", "")) ;
            }
            if (true) break;
         }
         AV28i = (short)(AV28i+1) ;
         AV41vuelta = (short)(AV41vuelta+1) ;
      }
      GXt_char6 = AV43alcanzaGananciasConCodigo ;
      GXt_char7 = AV43alcanzaGananciasConCodigo ;
      GXv_char1[0] = GXt_char7 ;
      new web.concepto_alcanzaganancias_codigoparam(remoteHandle, context).execute( GXv_char1) ;
      analizarconceptosuso.this.GXt_char7 = GXv_char1[0] ;
      GXv_char8[0] = GXt_char6 ;
      new web.getparametro(remoteHandle, context).execute( AV32CliCod, GXt_char7, GXv_char8) ;
      analizarconceptosuso.this.GXt_char6 = GXv_char8[0] ;
      AV43alcanzaGananciasConCodigo = GXt_char6 ;
      if ( GXutil.strcmp(AV23parm_ConCodigo, AV43alcanzaGananciasConCodigo) == 0 )
      {
         AV24itemConcepto = (web.Sdtsdt_conceptos_sdt_conceptosItem)new web.Sdtsdt_conceptos_sdt_conceptosItem(remoteHandle, context);
         AV24itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo( httpContext.getMessage( "F1357", "") );
         AV24itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip( httpContext.getMessage( "Formulario 1357", "") );
         AV24itemConcepto.setgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esconcepto( false );
         AV25sdt_conceptos.add(AV24itemConcepto, 0);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP10[0] = analizarconceptosuso.this.AV31seUsa;
      this.aP11[0] = analizarconceptosuso.this.AV37seUsaPeroEsCero;
      this.aP12[0] = analizarconceptosuso.this.AV25sdt_conceptos;
      this.aP13[0] = analizarconceptosuso.this.AV39LosQueLosUsanNoExisten;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV25sdt_conceptos = new GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem>(web.Sdtsdt_conceptos_sdt_conceptosItem.class, "sdt_conceptosItem", "PayDay", remoteHandle);
      AV34ConsiderarSolo = "" ;
      AV21ConCodigo = "" ;
      AV33concepto = "" ;
      AV47Pgmname = "" ;
      scmdbuf = "" ;
      A26ConCodigo = "" ;
      A37TipoConCod = "" ;
      P00AQ2_A37TipoConCod = new String[] {""} ;
      P00AQ2_A26ConCodigo = new String[] {""} ;
      P00AQ2_A3CliCod = new int[1] ;
      P00AQ2_A148ConFormula = new String[] {""} ;
      P00AQ2_n148ConFormula = new boolean[] {false} ;
      P00AQ2_A41ConDescrip = new String[] {""} ;
      A148ConFormula = "" ;
      A41ConDescrip = "" ;
      AV24itemConcepto = new web.Sdtsdt_conceptos_sdt_conceptosItem(remoteHandle, context);
      AV30LiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      GXv_boolean3 = new boolean[1] ;
      GXv_int5 = new byte[1] ;
      AV43alcanzaGananciasConCodigo = "" ;
      GXt_char6 = "" ;
      GXt_char7 = "" ;
      GXv_char1 = new String[1] ;
      GXv_char8 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.analizarconceptosuso__default(),
         new Object[] {
             new Object[] {
            P00AQ2_A37TipoConCod, P00AQ2_A26ConCodigo, P00AQ2_A3CliCod, P00AQ2_A148ConFormula, P00AQ2_n148ConFormula, P00AQ2_A41ConDescrip
            }
         }
      );
      AV47Pgmname = "analizarConceptosUso" ;
      /* GeneXus formulas. */
      AV47Pgmname = "analizarConceptosUso" ;
      Gx_err = (short)(0) ;
   }

   private byte AV48GXLvl32 ;
   private byte GXv_int5[] ;
   private short AV18EmpCod ;
   private short AV41vuelta ;
   private short AV27cntYaRecorridos ;
   private short AV28i ;
   private short Gx_err ;
   private int AV32CliCod ;
   private int AV20LiqNro ;
   private int AV19LegNumero ;
   private int A3CliCod ;
   private int AV49GXV1 ;
   private int AV50GXV2 ;
   private java.math.BigDecimal AV30LiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private String AV23parm_ConCodigo ;
   private String AV44TipoConCod ;
   private String AV42ConsiderarSolo_parm ;
   private String AV34ConsiderarSolo ;
   private String AV21ConCodigo ;
   private String AV33concepto ;
   private String AV47Pgmname ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A37TipoConCod ;
   private String AV43alcanzaGananciasConCodigo ;
   private String GXt_char6 ;
   private String GXt_char7 ;
   private String GXv_char1[] ;
   private String GXv_char8[] ;
   private boolean AV35devolverQuienesLoUsan ;
   private boolean AV36indirectos ;
   private boolean AV40analizarseASiMismo ;
   private boolean AV31seUsa ;
   private boolean AV37seUsaPeroEsCero ;
   private boolean AV39LosQueLosUsanNoExisten ;
   private boolean gxexitloop ;
   private boolean n148ConFormula ;
   private boolean AV26yaEsta ;
   private boolean AV29esConceptoImprimible ;
   private boolean GXt_boolean2 ;
   private boolean returnInSub ;
   private boolean AV38existe ;
   private boolean GXv_boolean3[] ;
   private String A148ConFormula ;
   private String A41ConDescrip ;
   private boolean[] aP13 ;
   private boolean[] aP10 ;
   private boolean[] aP11 ;
   private GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem>[] aP12 ;
   private IDataStoreProvider pr_default ;
   private String[] P00AQ2_A37TipoConCod ;
   private String[] P00AQ2_A26ConCodigo ;
   private int[] P00AQ2_A3CliCod ;
   private String[] P00AQ2_A148ConFormula ;
   private boolean[] P00AQ2_n148ConFormula ;
   private String[] P00AQ2_A41ConDescrip ;
   private GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem> AV25sdt_conceptos ;
   private web.Sdtsdt_conceptos_sdt_conceptosItem AV24itemConcepto ;
}

final  class analizarconceptosuso__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00AQ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV41vuelta ,
                                          String AV44TipoConCod ,
                                          String A26ConCodigo ,
                                          String AV23parm_ConCodigo ,
                                          String A37TipoConCod ,
                                          int AV32CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int9 = new byte[4];
      Object[] GXv_Object10 = new Object[2];
      scmdbuf = "SELECT TipoConCod, ConCodigo, CliCod, ConFormula, ConDescrip FROM Concepto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( AV41vuelta > 1 )
      {
         addWhere(sWhereString, "(ConCodigo <> ( ?))");
      }
      else
      {
         GXv_int9[1] = (byte)(1) ;
      }
      if ( AV41vuelta == 1 )
      {
         addWhere(sWhereString, "(ConCodigo = ( ?))");
      }
      else
      {
         GXv_int9[2] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV44TipoConCod)==0) )
      {
         addWhere(sWhereString, "(TipoConCod = ( ?))");
      }
      else
      {
         GXv_int9[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, TipoConCod, ConCodigo" ;
      GXv_Object10[0] = scmdbuf ;
      GXv_Object10[1] = GXv_int9 ;
      return GXv_Object10 ;
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
                  return conditional_P00AQ2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00AQ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
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
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 10);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 10);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 20);
               }
               return;
      }
   }

}

