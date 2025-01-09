package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtLiquidacion extends GxSilentTrnSdt
{
   public SdtLiquidacion( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtLiquidacion.class));
   }

   public SdtLiquidacion( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle, context, "SdtLiquidacion");
      initialize( remoteHandle) ;
   }

   public SdtLiquidacion( int remoteHandle ,
                          StructSdtLiquidacion struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public void Load( int AV3CliCod ,
                     short AV1EmpCod ,
                     int AV31LiqNro )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Integer.valueOf(AV3CliCod),Short.valueOf(AV1EmpCod),Integer.valueOf(AV31LiqNro)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CliCod", int.class}, new Object[]{"EmpCod", short.class}, new Object[]{"LiqNro", int.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Liquidacion");
      metadata.set("BT", "Liquidacion");
      metadata.set("PK", "[ \"CliCod\",\"EmpCod\",\"LiqNro\" ]");
      metadata.set("PKAssigned", "[ \"CliCod\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"BanCod\" ],\"FKMap\":[ \"LiqDepBanCod-BanCod\" ] },{ \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"LiqNro\" ],\"FKMap\":[ \"LiqRelNro-LiqNro\" ] },{ \"FK\":[ \"CliCod\",\"EmpCod\",\"PeriodoLiq\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"TLiqCod\" ],\"FKMap\":[  ] } ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod") )
            {
               gxTv_SdtLiquidacion_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_SdtLiquidacion_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpNom") )
            {
               gxTv_SdtLiquidacion_Empnom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNro") )
            {
               gxTv_SdtLiquidacion_Liqnro = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDescrip") )
            {
               gxTv_SdtLiquidacion_Liqdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqFecha") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqfecha = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqfecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerAno") )
            {
               gxTv_SdtLiquidacion_Liqperano = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerMes") )
            {
               gxTv_SdtLiquidacion_Liqpermes = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPeriodo") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqperiodo = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqperiodo = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqFecPago") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqfecpago = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqfecpago = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqCod") )
            {
               gxTv_SdtLiquidacion_Tliqcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TliqDesc") )
            {
               gxTv_SdtLiquidacion_Tliqdesc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqDescAux") )
            {
               gxTv_SdtLiquidacion_Tliqdescaux = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqEstado") )
            {
               gxTv_SdtLiquidacion_Liqestado = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLSDDepEst") )
            {
               gxTv_SdtLiquidacion_Liqlsddepest = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqAuxEstado") )
            {
               gxTv_SdtLiquidacion_Liqauxestado = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqContrEst") )
            {
               gxTv_SdtLiquidacion_Liqcontrest = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqClase") )
            {
               gxTv_SdtLiquidacion_Liqclase = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPDFEstado") )
            {
               gxTv_SdtLiquidacion_Liqpdfestado = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqGenInter") )
            {
               gxTv_SdtLiquidacion_Liqgeninter = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqContabilizada") )
            {
               gxTv_SdtLiquidacion_Liqcontabilizada = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqCntLeg") )
            {
               gxTv_SdtLiquidacion_Liqcntleg = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqImpNeto") )
            {
               gxTv_SdtLiquidacion_Liqimpneto = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqImpDescuentos") )
            {
               gxTv_SdtLiquidacion_Liqimpdescuentos = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqImpRetenGan") )
            {
               gxTv_SdtLiquidacion_Liqimpretengan = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqImpBruto") )
            {
               gxTv_SdtLiquidacion_Liqimpbruto = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegEspecificos") )
            {
               gxTv_SdtLiquidacion_Legespecificos = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqFecCre") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqfeccre = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqfeccre = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqUsuCre") )
            {
               gxTv_SdtLiquidacion_Liqusucre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerSinDia") )
            {
               gxTv_SdtLiquidacion_Liqpersindia = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerPalabra") )
            {
               gxTv_SdtLiquidacion_Liqperpalabra = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDepPrvPer") )
            {
               gxTv_SdtLiquidacion_Liqdepprvper = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDepPrvFec") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqdepprvfec = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqdepprvfec = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDepBanDescrip") )
            {
               gxTv_SdtLiquidacion_Liqdepbandescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDepBanCod") )
            {
               gxTv_SdtLiquidacion_Liqdepbancod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDepPerAno") )
            {
               gxTv_SdtLiquidacion_Liqdepperano = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDepPerMes") )
            {
               gxTv_SdtLiquidacion_Liqdeppermes = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqFecMod") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqfecmod = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqfecmod = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqUsuMod") )
            {
               gxTv_SdtLiquidacion_Liqusumod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqFecImp") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqfecimp = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqfecimp = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPisoGanancias") )
            {
               gxTv_SdtLiquidacion_Liqpisoganancias = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPisGanSAC") )
            {
               gxTv_SdtLiquidacion_Liqpisgansac = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqTopeDedInc") )
            {
               gxTv_SdtLiquidacion_Liqtopededinc = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerUltNorm") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqperultnorm = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqperultnorm = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqError") )
            {
               gxTv_SdtLiquidacion_Liqerror = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqErrorAux") )
            {
               gxTv_SdtLiquidacion_Liqerroraux = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNombre") )
            {
               gxTv_SdtLiquidacion_Liqnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegajosTxt") )
            {
               gxTv_SdtLiquidacion_Liqlegajostxt = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqSegundos") )
            {
               gxTv_SdtLiquidacion_Liqsegundos = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqRutaPDFTodosVertical") )
            {
               gxTv_SdtLiquidacion_Liqrutapdftodosvertical = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqRutaPDFTodosHorizontal") )
            {
               gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqRutaPDFTodosNombreVertical") )
            {
               gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqRutaPDFTodosNombreHorizontal") )
            {
               gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLog") )
            {
               gxTv_SdtLiquidacion_Liqlog = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PeriodoLiq") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Periodoliq = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacion_Periodoliq = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqRelNro") )
            {
               gxTv_SdtLiquidacion_Liqrelnro = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqSac") )
            {
               gxTv_SdtLiquidacion_Liqsac = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqSacLog") )
            {
               gxTv_SdtLiquidacion_Liqsaclog = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqCancel") )
            {
               gxTv_SdtLiquidacion_Liqcancel = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqModTra") )
            {
               gxTv_SdtLiquidacion_Liqmodtra = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqFrecPag") )
            {
               gxTv_SdtLiquidacion_Liqfrecpag = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerDes") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqperdes = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqperdes = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerHas") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqperhas = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqperhas = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqTipoTarifa") )
            {
               gxTv_SdtLiquidacion_Liqtipotarifa = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtLiquidacion_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtLiquidacion_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod_Z") )
            {
               gxTv_SdtLiquidacion_Clicod_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod_Z") )
            {
               gxTv_SdtLiquidacion_Empcod_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpNom_Z") )
            {
               gxTv_SdtLiquidacion_Empnom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNro_Z") )
            {
               gxTv_SdtLiquidacion_Liqnro_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDescrip_Z") )
            {
               gxTv_SdtLiquidacion_Liqdescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqFecha_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqfecha_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqfecha_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerAno_Z") )
            {
               gxTv_SdtLiquidacion_Liqperano_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerMes_Z") )
            {
               gxTv_SdtLiquidacion_Liqpermes_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPeriodo_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqperiodo_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqperiodo_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqFecPago_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqfecpago_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqfecpago_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqCod_Z") )
            {
               gxTv_SdtLiquidacion_Tliqcod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TliqDesc_Z") )
            {
               gxTv_SdtLiquidacion_Tliqdesc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqDescAux_Z") )
            {
               gxTv_SdtLiquidacion_Tliqdescaux_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqEstado_Z") )
            {
               gxTv_SdtLiquidacion_Liqestado_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLSDDepEst_Z") )
            {
               gxTv_SdtLiquidacion_Liqlsddepest_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqAuxEstado_Z") )
            {
               gxTv_SdtLiquidacion_Liqauxestado_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqContrEst_Z") )
            {
               gxTv_SdtLiquidacion_Liqcontrest_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqClase_Z") )
            {
               gxTv_SdtLiquidacion_Liqclase_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPDFEstado_Z") )
            {
               gxTv_SdtLiquidacion_Liqpdfestado_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqGenInter_Z") )
            {
               gxTv_SdtLiquidacion_Liqgeninter_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqContabilizada_Z") )
            {
               gxTv_SdtLiquidacion_Liqcontabilizada_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqCntLeg_Z") )
            {
               gxTv_SdtLiquidacion_Liqcntleg_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqImpNeto_Z") )
            {
               gxTv_SdtLiquidacion_Liqimpneto_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqImpDescuentos_Z") )
            {
               gxTv_SdtLiquidacion_Liqimpdescuentos_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqImpRetenGan_Z") )
            {
               gxTv_SdtLiquidacion_Liqimpretengan_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqImpBruto_Z") )
            {
               gxTv_SdtLiquidacion_Liqimpbruto_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegEspecificos_Z") )
            {
               gxTv_SdtLiquidacion_Legespecificos_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqFecCre_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqfeccre_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqfeccre_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqUsuCre_Z") )
            {
               gxTv_SdtLiquidacion_Liqusucre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerSinDia_Z") )
            {
               gxTv_SdtLiquidacion_Liqpersindia_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerPalabra_Z") )
            {
               gxTv_SdtLiquidacion_Liqperpalabra_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDepPrvPer_Z") )
            {
               gxTv_SdtLiquidacion_Liqdepprvper_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDepPrvFec_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqdepprvfec_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqdepprvfec_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDepBanDescrip_Z") )
            {
               gxTv_SdtLiquidacion_Liqdepbandescrip_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDepBanCod_Z") )
            {
               gxTv_SdtLiquidacion_Liqdepbancod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDepPerAno_Z") )
            {
               gxTv_SdtLiquidacion_Liqdepperano_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDepPerMes_Z") )
            {
               gxTv_SdtLiquidacion_Liqdeppermes_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqFecMod_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqfecmod_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqfecmod_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqUsuMod_Z") )
            {
               gxTv_SdtLiquidacion_Liqusumod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqFecImp_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqfecimp_Z = GXutil.resetTime( GXutil.nullDate() );
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqfecimp_Z = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPisoGanancias_Z") )
            {
               gxTv_SdtLiquidacion_Liqpisoganancias_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPisGanSAC_Z") )
            {
               gxTv_SdtLiquidacion_Liqpisgansac_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqTopeDedInc_Z") )
            {
               gxTv_SdtLiquidacion_Liqtopededinc_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerUltNorm_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqperultnorm_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqperultnorm_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqError_Z") )
            {
               gxTv_SdtLiquidacion_Liqerror_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqErrorAux_Z") )
            {
               gxTv_SdtLiquidacion_Liqerroraux_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNombre_Z") )
            {
               gxTv_SdtLiquidacion_Liqnombre_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegajosTxt_Z") )
            {
               gxTv_SdtLiquidacion_Liqlegajostxt_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqSegundos_Z") )
            {
               gxTv_SdtLiquidacion_Liqsegundos_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqRutaPDFTodosVertical_Z") )
            {
               gxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqRutaPDFTodosHorizontal_Z") )
            {
               gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqRutaPDFTodosNombreVertical_Z") )
            {
               gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqRutaPDFTodosNombreHorizontal_Z") )
            {
               gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PeriodoLiq_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Periodoliq_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacion_Periodoliq_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqRelNro_Z") )
            {
               gxTv_SdtLiquidacion_Liqrelnro_Z = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqSac_Z") )
            {
               gxTv_SdtLiquidacion_Liqsac_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqSacLog_Z") )
            {
               gxTv_SdtLiquidacion_Liqsaclog_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqCancel_Z") )
            {
               gxTv_SdtLiquidacion_Liqcancel_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqModTra_Z") )
            {
               gxTv_SdtLiquidacion_Liqmodtra_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqFrecPag_Z") )
            {
               gxTv_SdtLiquidacion_Liqfrecpag_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerDes_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqperdes_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqperdes_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerHas_Z") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtLiquidacion_Liqperhas_Z = GXutil.nullDate() ;
               }
               else
               {
                  gxTv_SdtLiquidacion_Liqperhas_Z = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqTipoTarifa_Z") )
            {
               gxTv_SdtLiquidacion_Liqtipotarifa_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqCod_N") )
            {
               gxTv_SdtLiquidacion_Tliqcod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqClase_N") )
            {
               gxTv_SdtLiquidacion_Liqclase_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPDFEstado_N") )
            {
               gxTv_SdtLiquidacion_Liqpdfestado_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDepBanCod_N") )
            {
               gxTv_SdtLiquidacion_Liqdepbancod_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqRelNro_N") )
            {
               gxTv_SdtLiquidacion_Liqrelnro_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqSac_N") )
            {
               gxTv_SdtLiquidacion_Liqsac_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqSacLog_N") )
            {
               gxTv_SdtLiquidacion_Liqsaclog_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "Liquidacion" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpNom", gxTv_SdtLiquidacion_Empnom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqNro", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqnro, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqDescrip", gxTv_SdtLiquidacion_Liqdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LiqFecha", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqPerAno", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqperano, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqPerMes", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqpermes, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LiqPeriodo", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqfecpago), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqfecpago), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqfecpago), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LiqFecPago", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TLiqCod", gxTv_SdtLiquidacion_Tliqcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TliqDesc", gxTv_SdtLiquidacion_Tliqdesc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TLiqDescAux", gxTv_SdtLiquidacion_Tliqdescaux);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqEstado", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqestado, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLSDDepEst", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqlsddepest, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqAuxEstado", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqauxestado, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqContrEst", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqcontrest, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqClase", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqclase, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqPDFEstado", gxTv_SdtLiquidacion_Liqpdfestado);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqGenInter", GXutil.booltostr( gxTv_SdtLiquidacion_Liqgeninter));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqContabilizada", GXutil.booltostr( gxTv_SdtLiquidacion_Liqcontabilizada));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqCntLeg", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqcntleg, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqImpNeto", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacion_Liqimpneto, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqImpDescuentos", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacion_Liqimpdescuentos, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqImpRetenGan", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacion_Liqimpretengan, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqImpBruto", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacion_Liqimpbruto, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegEspecificos", GXutil.booltostr( gxTv_SdtLiquidacion_Legespecificos));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqfeccre), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqfeccre), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqfeccre), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LiqFecCre", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqUsuCre", gxTv_SdtLiquidacion_Liqusucre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqPerSinDia", gxTv_SdtLiquidacion_Liqpersindia);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqPerPalabra", gxTv_SdtLiquidacion_Liqperpalabra);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqDepPrvPer", gxTv_SdtLiquidacion_Liqdepprvper);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqdepprvfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqdepprvfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqdepprvfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LiqDepPrvFec", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqDepBanDescrip", gxTv_SdtLiquidacion_Liqdepbandescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqDepBanCod", gxTv_SdtLiquidacion_Liqdepbancod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqDepPerAno", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqdepperano, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqDepPerMes", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqdeppermes, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqfecmod), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqfecmod), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqfecmod), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtLiquidacion_Liqfecmod), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtLiquidacion_Liqfecmod), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtLiquidacion_Liqfecmod), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LiqFecMod", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqUsuMod", gxTv_SdtLiquidacion_Liqusumod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqfecimp), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqfecimp), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqfecimp), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtLiquidacion_Liqfecimp), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtLiquidacion_Liqfecimp), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtLiquidacion_Liqfecimp), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LiqFecImp", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqPisoGanancias", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacion_Liqpisoganancias, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqPisGanSAC", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacion_Liqpisgansac, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqTopeDedInc", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacion_Liqtopededinc, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqperultnorm), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqperultnorm), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqperultnorm), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LiqPerUltNorm", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqError", gxTv_SdtLiquidacion_Liqerror);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqErrorAux", gxTv_SdtLiquidacion_Liqerroraux);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqNombre", gxTv_SdtLiquidacion_Liqnombre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegajosTxt", gxTv_SdtLiquidacion_Liqlegajostxt);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqSegundos", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacion_Liqsegundos, 5, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqRutaPDFTodosVertical", gxTv_SdtLiquidacion_Liqrutapdftodosvertical);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqRutaPDFTodosHorizontal", gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqRutaPDFTodosNombreVertical", gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqRutaPDFTodosNombreHorizontal", gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLog", gxTv_SdtLiquidacion_Liqlog);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Periodoliq), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Periodoliq), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Periodoliq), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("PeriodoLiq", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqRelNro", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqrelnro, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqSac", GXutil.booltostr( gxTv_SdtLiquidacion_Liqsac));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqSacLog", gxTv_SdtLiquidacion_Liqsaclog);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqCancel", GXutil.booltostr( gxTv_SdtLiquidacion_Liqcancel));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqModTra", gxTv_SdtLiquidacion_Liqmodtra);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqFrecPag", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqfrecpag, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqperdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqperdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqperdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LiqPerDes", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqperhas), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqperhas), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqperhas), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      oWriter.writeElement("LiqPerHas", sDateCnv);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqTipoTarifa", gxTv_SdtLiquidacion_Liqtipotarifa);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtLiquidacion_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CliCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Clicod_Z, 6, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpCod_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Empcod_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpNom_Z", gxTv_SdtLiquidacion_Empnom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqNro_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqnro_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqDescrip_Z", gxTv_SdtLiquidacion_Liqdescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqFecha_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqPerAno_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqperano_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqPerMes_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqpermes_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqperiodo_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqperiodo_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqperiodo_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqPeriodo_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqfecpago_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqfecpago_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqfecpago_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqFecPago_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TLiqCod_Z", gxTv_SdtLiquidacion_Tliqcod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TliqDesc_Z", gxTv_SdtLiquidacion_Tliqdesc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TLiqDescAux_Z", gxTv_SdtLiquidacion_Tliqdescaux_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqEstado_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqestado_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLSDDepEst_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqlsddepest_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqAuxEstado_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqauxestado_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqContrEst_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqcontrest_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqClase_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqclase_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqPDFEstado_Z", gxTv_SdtLiquidacion_Liqpdfestado_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqGenInter_Z", GXutil.booltostr( gxTv_SdtLiquidacion_Liqgeninter_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqContabilizada_Z", GXutil.booltostr( gxTv_SdtLiquidacion_Liqcontabilizada_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqCntLeg_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqcntleg_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqImpNeto_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacion_Liqimpneto_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqImpDescuentos_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacion_Liqimpdescuentos_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqImpRetenGan_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacion_Liqimpretengan_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqImpBruto_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacion_Liqimpbruto_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LegEspecificos_Z", GXutil.booltostr( gxTv_SdtLiquidacion_Legespecificos_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqfeccre_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqfeccre_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqfeccre_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqFecCre_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqUsuCre_Z", gxTv_SdtLiquidacion_Liqusucre_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqPerSinDia_Z", gxTv_SdtLiquidacion_Liqpersindia_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqPerPalabra_Z", gxTv_SdtLiquidacion_Liqperpalabra_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqDepPrvPer_Z", gxTv_SdtLiquidacion_Liqdepprvper_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqdepprvfec_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqdepprvfec_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqdepprvfec_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqDepPrvFec_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqDepBanDescrip_Z", gxTv_SdtLiquidacion_Liqdepbandescrip_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqDepBanCod_Z", gxTv_SdtLiquidacion_Liqdepbancod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqDepPerAno_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqdepperano_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqDepPerMes_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqdeppermes_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqfecmod_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqfecmod_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqfecmod_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtLiquidacion_Liqfecmod_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtLiquidacion_Liqfecmod_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtLiquidacion_Liqfecmod_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqFecMod_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqUsuMod_Z", gxTv_SdtLiquidacion_Liqusumod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqfecimp_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqfecimp_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqfecimp_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_SdtLiquidacion_Liqfecimp_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_SdtLiquidacion_Liqfecimp_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_SdtLiquidacion_Liqfecimp_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqFecImp_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqPisoGanancias_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacion_Liqpisoganancias_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqPisGanSAC_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacion_Liqpisgansac_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqTopeDedInc_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacion_Liqtopededinc_Z, 14, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqperultnorm_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqperultnorm_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqperultnorm_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqPerUltNorm_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqError_Z", gxTv_SdtLiquidacion_Liqerror_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqErrorAux_Z", gxTv_SdtLiquidacion_Liqerroraux_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqNombre_Z", gxTv_SdtLiquidacion_Liqnombre_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqLegajosTxt_Z", gxTv_SdtLiquidacion_Liqlegajostxt_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqSegundos_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtLiquidacion_Liqsegundos_Z, 5, 2)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqRutaPDFTodosVertical_Z", gxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqRutaPDFTodosHorizontal_Z", gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqRutaPDFTodosNombreVertical_Z", gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqRutaPDFTodosNombreHorizontal_Z", gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Periodoliq_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Periodoliq_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Periodoliq_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("PeriodoLiq_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqRelNro_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqrelnro_Z, 8, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqSac_Z", GXutil.booltostr( gxTv_SdtLiquidacion_Liqsac_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqSacLog_Z", gxTv_SdtLiquidacion_Liqsaclog_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqCancel_Z", GXutil.booltostr( gxTv_SdtLiquidacion_Liqcancel_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqModTra_Z", gxTv_SdtLiquidacion_Liqmodtra_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqFrecPag_Z", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqfrecpag_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqperdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqperdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqperdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqPerDes_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqperhas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqperhas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqperhas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqPerHas_Z", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqTipoTarifa_Z", gxTv_SdtLiquidacion_Liqtipotarifa_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TLiqCod_N", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Tliqcod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqClase_N", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqclase_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqPDFEstado_N", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqpdfestado_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqDepBanCod_N", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqdepbancod_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqRelNro_N", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqrelnro_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqSac_N", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqsac_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("LiqSacLog_N", GXutil.trim( GXutil.str( gxTv_SdtLiquidacion_Liqsaclog_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("CliCod", gxTv_SdtLiquidacion_Clicod, false, includeNonInitialized);
      AddObjectProperty("EmpCod", gxTv_SdtLiquidacion_Empcod, false, includeNonInitialized);
      AddObjectProperty("EmpNom", gxTv_SdtLiquidacion_Empnom, false, includeNonInitialized);
      AddObjectProperty("LiqNro", gxTv_SdtLiquidacion_Liqnro, false, includeNonInitialized);
      AddObjectProperty("LiqDescrip", gxTv_SdtLiquidacion_Liqdescrip, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqFecha", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LiqPerAno", gxTv_SdtLiquidacion_Liqperano, false, includeNonInitialized);
      AddObjectProperty("LiqPerMes", gxTv_SdtLiquidacion_Liqpermes, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqPeriodo", sDateCnv, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqfecpago), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqfecpago), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqfecpago), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqFecPago", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("TLiqCod", gxTv_SdtLiquidacion_Tliqcod, false, includeNonInitialized);
      AddObjectProperty("TLiqCod_N", gxTv_SdtLiquidacion_Tliqcod_N, false, includeNonInitialized);
      AddObjectProperty("TliqDesc", gxTv_SdtLiquidacion_Tliqdesc, false, includeNonInitialized);
      AddObjectProperty("TLiqDescAux", gxTv_SdtLiquidacion_Tliqdescaux, false, includeNonInitialized);
      AddObjectProperty("LiqEstado", gxTv_SdtLiquidacion_Liqestado, false, includeNonInitialized);
      AddObjectProperty("LiqLSDDepEst", gxTv_SdtLiquidacion_Liqlsddepest, false, includeNonInitialized);
      AddObjectProperty("LiqAuxEstado", gxTv_SdtLiquidacion_Liqauxestado, false, includeNonInitialized);
      AddObjectProperty("LiqContrEst", gxTv_SdtLiquidacion_Liqcontrest, false, includeNonInitialized);
      AddObjectProperty("LiqClase", gxTv_SdtLiquidacion_Liqclase, false, includeNonInitialized);
      AddObjectProperty("LiqClase_N", gxTv_SdtLiquidacion_Liqclase_N, false, includeNonInitialized);
      AddObjectProperty("LiqPDFEstado", gxTv_SdtLiquidacion_Liqpdfestado, false, includeNonInitialized);
      AddObjectProperty("LiqPDFEstado_N", gxTv_SdtLiquidacion_Liqpdfestado_N, false, includeNonInitialized);
      AddObjectProperty("LiqGenInter", gxTv_SdtLiquidacion_Liqgeninter, false, includeNonInitialized);
      AddObjectProperty("LiqContabilizada", gxTv_SdtLiquidacion_Liqcontabilizada, false, includeNonInitialized);
      AddObjectProperty("LiqCntLeg", gxTv_SdtLiquidacion_Liqcntleg, false, includeNonInitialized);
      AddObjectProperty("LiqImpNeto", gxTv_SdtLiquidacion_Liqimpneto, false, includeNonInitialized);
      AddObjectProperty("LiqImpDescuentos", gxTv_SdtLiquidacion_Liqimpdescuentos, false, includeNonInitialized);
      AddObjectProperty("LiqImpRetenGan", gxTv_SdtLiquidacion_Liqimpretengan, false, includeNonInitialized);
      AddObjectProperty("LiqImpBruto", gxTv_SdtLiquidacion_Liqimpbruto, false, includeNonInitialized);
      AddObjectProperty("LegEspecificos", gxTv_SdtLiquidacion_Legespecificos, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqfeccre), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqfeccre), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqfeccre), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqFecCre", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LiqUsuCre", gxTv_SdtLiquidacion_Liqusucre, false, includeNonInitialized);
      AddObjectProperty("LiqPerSinDia", gxTv_SdtLiquidacion_Liqpersindia, false, includeNonInitialized);
      AddObjectProperty("LiqPerPalabra", gxTv_SdtLiquidacion_Liqperpalabra, false, includeNonInitialized);
      AddObjectProperty("LiqDepPrvPer", gxTv_SdtLiquidacion_Liqdepprvper, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqdepprvfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqdepprvfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqdepprvfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqDepPrvFec", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LiqDepBanDescrip", gxTv_SdtLiquidacion_Liqdepbandescrip, false, includeNonInitialized);
      AddObjectProperty("LiqDepBanCod", gxTv_SdtLiquidacion_Liqdepbancod, false, includeNonInitialized);
      AddObjectProperty("LiqDepBanCod_N", gxTv_SdtLiquidacion_Liqdepbancod_N, false, includeNonInitialized);
      AddObjectProperty("LiqDepPerAno", gxTv_SdtLiquidacion_Liqdepperano, false, includeNonInitialized);
      AddObjectProperty("LiqDepPerMes", gxTv_SdtLiquidacion_Liqdeppermes, false, includeNonInitialized);
      datetime_STZ = gxTv_SdtLiquidacion_Liqfecmod ;
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqFecMod", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LiqUsuMod", gxTv_SdtLiquidacion_Liqusumod, false, includeNonInitialized);
      datetime_STZ = gxTv_SdtLiquidacion_Liqfecimp ;
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "T" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += ":" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqFecImp", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LiqPisoGanancias", gxTv_SdtLiquidacion_Liqpisoganancias, false, includeNonInitialized);
      AddObjectProperty("LiqPisGanSAC", gxTv_SdtLiquidacion_Liqpisgansac, false, includeNonInitialized);
      AddObjectProperty("LiqTopeDedInc", gxTv_SdtLiquidacion_Liqtopededinc, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqperultnorm), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqperultnorm), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqperultnorm), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqPerUltNorm", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LiqError", gxTv_SdtLiquidacion_Liqerror, false, includeNonInitialized);
      AddObjectProperty("LiqErrorAux", gxTv_SdtLiquidacion_Liqerroraux, false, includeNonInitialized);
      AddObjectProperty("LiqNombre", gxTv_SdtLiquidacion_Liqnombre, false, includeNonInitialized);
      AddObjectProperty("LiqLegajosTxt", gxTv_SdtLiquidacion_Liqlegajostxt, false, includeNonInitialized);
      AddObjectProperty("LiqSegundos", gxTv_SdtLiquidacion_Liqsegundos, false, includeNonInitialized);
      AddObjectProperty("LiqRutaPDFTodosVertical", gxTv_SdtLiquidacion_Liqrutapdftodosvertical, false, includeNonInitialized);
      AddObjectProperty("LiqRutaPDFTodosHorizontal", gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal, false, includeNonInitialized);
      AddObjectProperty("LiqRutaPDFTodosNombreVertical", gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical, false, includeNonInitialized);
      AddObjectProperty("LiqRutaPDFTodosNombreHorizontal", gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal, false, includeNonInitialized);
      AddObjectProperty("LiqLog", gxTv_SdtLiquidacion_Liqlog, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Periodoliq), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Periodoliq), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Periodoliq), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("PeriodoLiq", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LiqRelNro", gxTv_SdtLiquidacion_Liqrelnro, false, includeNonInitialized);
      AddObjectProperty("LiqRelNro_N", gxTv_SdtLiquidacion_Liqrelnro_N, false, includeNonInitialized);
      AddObjectProperty("LiqSac", gxTv_SdtLiquidacion_Liqsac, false, includeNonInitialized);
      AddObjectProperty("LiqSac_N", gxTv_SdtLiquidacion_Liqsac_N, false, includeNonInitialized);
      AddObjectProperty("LiqSacLog", gxTv_SdtLiquidacion_Liqsaclog, false, includeNonInitialized);
      AddObjectProperty("LiqSacLog_N", gxTv_SdtLiquidacion_Liqsaclog_N, false, includeNonInitialized);
      AddObjectProperty("LiqCancel", gxTv_SdtLiquidacion_Liqcancel, false, includeNonInitialized);
      AddObjectProperty("LiqModTra", gxTv_SdtLiquidacion_Liqmodtra, false, includeNonInitialized);
      AddObjectProperty("LiqFrecPag", gxTv_SdtLiquidacion_Liqfrecpag, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqperdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqperdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqperdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqPerDes", sDateCnv, false, includeNonInitialized);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqperhas), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqperhas), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqperhas), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqPerHas", sDateCnv, false, includeNonInitialized);
      AddObjectProperty("LiqTipoTarifa", gxTv_SdtLiquidacion_Liqtipotarifa, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtLiquidacion_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtLiquidacion_Initialized, false, includeNonInitialized);
         AddObjectProperty("CliCod_Z", gxTv_SdtLiquidacion_Clicod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpCod_Z", gxTv_SdtLiquidacion_Empcod_Z, false, includeNonInitialized);
         AddObjectProperty("EmpNom_Z", gxTv_SdtLiquidacion_Empnom_Z, false, includeNonInitialized);
         AddObjectProperty("LiqNro_Z", gxTv_SdtLiquidacion_Liqnro_Z, false, includeNonInitialized);
         AddObjectProperty("LiqDescrip_Z", gxTv_SdtLiquidacion_Liqdescrip_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqfecha_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LiqFecha_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LiqPerAno_Z", gxTv_SdtLiquidacion_Liqperano_Z, false, includeNonInitialized);
         AddObjectProperty("LiqPerMes_Z", gxTv_SdtLiquidacion_Liqpermes_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqperiodo_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqperiodo_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqperiodo_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LiqPeriodo_Z", sDateCnv, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqfecpago_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqfecpago_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqfecpago_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LiqFecPago_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("TLiqCod_Z", gxTv_SdtLiquidacion_Tliqcod_Z, false, includeNonInitialized);
         AddObjectProperty("TliqDesc_Z", gxTv_SdtLiquidacion_Tliqdesc_Z, false, includeNonInitialized);
         AddObjectProperty("TLiqDescAux_Z", gxTv_SdtLiquidacion_Tliqdescaux_Z, false, includeNonInitialized);
         AddObjectProperty("LiqEstado_Z", gxTv_SdtLiquidacion_Liqestado_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLSDDepEst_Z", gxTv_SdtLiquidacion_Liqlsddepest_Z, false, includeNonInitialized);
         AddObjectProperty("LiqAuxEstado_Z", gxTv_SdtLiquidacion_Liqauxestado_Z, false, includeNonInitialized);
         AddObjectProperty("LiqContrEst_Z", gxTv_SdtLiquidacion_Liqcontrest_Z, false, includeNonInitialized);
         AddObjectProperty("LiqClase_Z", gxTv_SdtLiquidacion_Liqclase_Z, false, includeNonInitialized);
         AddObjectProperty("LiqPDFEstado_Z", gxTv_SdtLiquidacion_Liqpdfestado_Z, false, includeNonInitialized);
         AddObjectProperty("LiqGenInter_Z", gxTv_SdtLiquidacion_Liqgeninter_Z, false, includeNonInitialized);
         AddObjectProperty("LiqContabilizada_Z", gxTv_SdtLiquidacion_Liqcontabilizada_Z, false, includeNonInitialized);
         AddObjectProperty("LiqCntLeg_Z", gxTv_SdtLiquidacion_Liqcntleg_Z, false, includeNonInitialized);
         AddObjectProperty("LiqImpNeto_Z", gxTv_SdtLiquidacion_Liqimpneto_Z, false, includeNonInitialized);
         AddObjectProperty("LiqImpDescuentos_Z", gxTv_SdtLiquidacion_Liqimpdescuentos_Z, false, includeNonInitialized);
         AddObjectProperty("LiqImpRetenGan_Z", gxTv_SdtLiquidacion_Liqimpretengan_Z, false, includeNonInitialized);
         AddObjectProperty("LiqImpBruto_Z", gxTv_SdtLiquidacion_Liqimpbruto_Z, false, includeNonInitialized);
         AddObjectProperty("LegEspecificos_Z", gxTv_SdtLiquidacion_Legespecificos_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqfeccre_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqfeccre_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqfeccre_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LiqFecCre_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LiqUsuCre_Z", gxTv_SdtLiquidacion_Liqusucre_Z, false, includeNonInitialized);
         AddObjectProperty("LiqPerSinDia_Z", gxTv_SdtLiquidacion_Liqpersindia_Z, false, includeNonInitialized);
         AddObjectProperty("LiqPerPalabra_Z", gxTv_SdtLiquidacion_Liqperpalabra_Z, false, includeNonInitialized);
         AddObjectProperty("LiqDepPrvPer_Z", gxTv_SdtLiquidacion_Liqdepprvper_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqdepprvfec_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqdepprvfec_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqdepprvfec_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LiqDepPrvFec_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LiqDepBanDescrip_Z", gxTv_SdtLiquidacion_Liqdepbandescrip_Z, false, includeNonInitialized);
         AddObjectProperty("LiqDepBanCod_Z", gxTv_SdtLiquidacion_Liqdepbancod_Z, false, includeNonInitialized);
         AddObjectProperty("LiqDepPerAno_Z", gxTv_SdtLiquidacion_Liqdepperano_Z, false, includeNonInitialized);
         AddObjectProperty("LiqDepPerMes_Z", gxTv_SdtLiquidacion_Liqdeppermes_Z, false, includeNonInitialized);
         datetime_STZ = gxTv_SdtLiquidacion_Liqfecmod_Z ;
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LiqFecMod_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LiqUsuMod_Z", gxTv_SdtLiquidacion_Liqusumod_Z, false, includeNonInitialized);
         datetime_STZ = gxTv_SdtLiquidacion_Liqfecimp_Z ;
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( datetime_STZ), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LiqFecImp_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LiqPisoGanancias_Z", gxTv_SdtLiquidacion_Liqpisoganancias_Z, false, includeNonInitialized);
         AddObjectProperty("LiqPisGanSAC_Z", gxTv_SdtLiquidacion_Liqpisgansac_Z, false, includeNonInitialized);
         AddObjectProperty("LiqTopeDedInc_Z", gxTv_SdtLiquidacion_Liqtopededinc_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqperultnorm_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqperultnorm_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqperultnorm_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LiqPerUltNorm_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LiqError_Z", gxTv_SdtLiquidacion_Liqerror_Z, false, includeNonInitialized);
         AddObjectProperty("LiqErrorAux_Z", gxTv_SdtLiquidacion_Liqerroraux_Z, false, includeNonInitialized);
         AddObjectProperty("LiqNombre_Z", gxTv_SdtLiquidacion_Liqnombre_Z, false, includeNonInitialized);
         AddObjectProperty("LiqLegajosTxt_Z", gxTv_SdtLiquidacion_Liqlegajostxt_Z, false, includeNonInitialized);
         AddObjectProperty("LiqSegundos_Z", gxTv_SdtLiquidacion_Liqsegundos_Z, false, includeNonInitialized);
         AddObjectProperty("LiqRutaPDFTodosVertical_Z", gxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z, false, includeNonInitialized);
         AddObjectProperty("LiqRutaPDFTodosHorizontal_Z", gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z, false, includeNonInitialized);
         AddObjectProperty("LiqRutaPDFTodosNombreVertical_Z", gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z, false, includeNonInitialized);
         AddObjectProperty("LiqRutaPDFTodosNombreHorizontal_Z", gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Periodoliq_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Periodoliq_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Periodoliq_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("PeriodoLiq_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LiqRelNro_Z", gxTv_SdtLiquidacion_Liqrelnro_Z, false, includeNonInitialized);
         AddObjectProperty("LiqSac_Z", gxTv_SdtLiquidacion_Liqsac_Z, false, includeNonInitialized);
         AddObjectProperty("LiqSacLog_Z", gxTv_SdtLiquidacion_Liqsaclog_Z, false, includeNonInitialized);
         AddObjectProperty("LiqCancel_Z", gxTv_SdtLiquidacion_Liqcancel_Z, false, includeNonInitialized);
         AddObjectProperty("LiqModTra_Z", gxTv_SdtLiquidacion_Liqmodtra_Z, false, includeNonInitialized);
         AddObjectProperty("LiqFrecPag_Z", gxTv_SdtLiquidacion_Liqfrecpag_Z, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqperdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqperdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqperdes_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LiqPerDes_Z", sDateCnv, false, includeNonInitialized);
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtLiquidacion_Liqperhas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtLiquidacion_Liqperhas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtLiquidacion_Liqperhas_Z), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         AddObjectProperty("LiqPerHas_Z", sDateCnv, false, includeNonInitialized);
         AddObjectProperty("LiqTipoTarifa_Z", gxTv_SdtLiquidacion_Liqtipotarifa_Z, false, includeNonInitialized);
         AddObjectProperty("TLiqCod_N", gxTv_SdtLiquidacion_Tliqcod_N, false, includeNonInitialized);
         AddObjectProperty("LiqClase_N", gxTv_SdtLiquidacion_Liqclase_N, false, includeNonInitialized);
         AddObjectProperty("LiqPDFEstado_N", gxTv_SdtLiquidacion_Liqpdfestado_N, false, includeNonInitialized);
         AddObjectProperty("LiqDepBanCod_N", gxTv_SdtLiquidacion_Liqdepbancod_N, false, includeNonInitialized);
         AddObjectProperty("LiqRelNro_N", gxTv_SdtLiquidacion_Liqrelnro_N, false, includeNonInitialized);
         AddObjectProperty("LiqSac_N", gxTv_SdtLiquidacion_Liqsac_N, false, includeNonInitialized);
         AddObjectProperty("LiqSacLog_N", gxTv_SdtLiquidacion_Liqsaclog_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtLiquidacion sdt )
   {
      if ( sdt.IsDirty("CliCod") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Clicod = sdt.getgxTv_SdtLiquidacion_Clicod() ;
      }
      if ( sdt.IsDirty("EmpCod") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Empcod = sdt.getgxTv_SdtLiquidacion_Empcod() ;
      }
      if ( sdt.IsDirty("EmpNom") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Empnom = sdt.getgxTv_SdtLiquidacion_Empnom() ;
      }
      if ( sdt.IsDirty("LiqNro") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqnro = sdt.getgxTv_SdtLiquidacion_Liqnro() ;
      }
      if ( sdt.IsDirty("LiqDescrip") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqdescrip = sdt.getgxTv_SdtLiquidacion_Liqdescrip() ;
      }
      if ( sdt.IsDirty("LiqFecha") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqfecha = sdt.getgxTv_SdtLiquidacion_Liqfecha() ;
      }
      if ( sdt.IsDirty("LiqPerAno") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqperano = sdt.getgxTv_SdtLiquidacion_Liqperano() ;
      }
      if ( sdt.IsDirty("LiqPerMes") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqpermes = sdt.getgxTv_SdtLiquidacion_Liqpermes() ;
      }
      if ( sdt.IsDirty("LiqPeriodo") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqperiodo = sdt.getgxTv_SdtLiquidacion_Liqperiodo() ;
      }
      if ( sdt.IsDirty("LiqFecPago") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqfecpago = sdt.getgxTv_SdtLiquidacion_Liqfecpago() ;
      }
      if ( sdt.IsDirty("TLiqCod") )
      {
         gxTv_SdtLiquidacion_Tliqcod_N = sdt.getgxTv_SdtLiquidacion_Tliqcod_N() ;
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Tliqcod = sdt.getgxTv_SdtLiquidacion_Tliqcod() ;
      }
      if ( sdt.IsDirty("TliqDesc") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Tliqdesc = sdt.getgxTv_SdtLiquidacion_Tliqdesc() ;
      }
      if ( sdt.IsDirty("TLiqDescAux") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Tliqdescaux = sdt.getgxTv_SdtLiquidacion_Tliqdescaux() ;
      }
      if ( sdt.IsDirty("LiqEstado") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqestado = sdt.getgxTv_SdtLiquidacion_Liqestado() ;
      }
      if ( sdt.IsDirty("LiqLSDDepEst") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqlsddepest = sdt.getgxTv_SdtLiquidacion_Liqlsddepest() ;
      }
      if ( sdt.IsDirty("LiqAuxEstado") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqauxestado = sdt.getgxTv_SdtLiquidacion_Liqauxestado() ;
      }
      if ( sdt.IsDirty("LiqContrEst") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqcontrest = sdt.getgxTv_SdtLiquidacion_Liqcontrest() ;
      }
      if ( sdt.IsDirty("LiqClase") )
      {
         gxTv_SdtLiquidacion_Liqclase_N = sdt.getgxTv_SdtLiquidacion_Liqclase_N() ;
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqclase = sdt.getgxTv_SdtLiquidacion_Liqclase() ;
      }
      if ( sdt.IsDirty("LiqPDFEstado") )
      {
         gxTv_SdtLiquidacion_Liqpdfestado_N = sdt.getgxTv_SdtLiquidacion_Liqpdfestado_N() ;
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqpdfestado = sdt.getgxTv_SdtLiquidacion_Liqpdfestado() ;
      }
      if ( sdt.IsDirty("LiqGenInter") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqgeninter = sdt.getgxTv_SdtLiquidacion_Liqgeninter() ;
      }
      if ( sdt.IsDirty("LiqContabilizada") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqcontabilizada = sdt.getgxTv_SdtLiquidacion_Liqcontabilizada() ;
      }
      if ( sdt.IsDirty("LiqCntLeg") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqcntleg = sdt.getgxTv_SdtLiquidacion_Liqcntleg() ;
      }
      if ( sdt.IsDirty("LiqImpNeto") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqimpneto = sdt.getgxTv_SdtLiquidacion_Liqimpneto() ;
      }
      if ( sdt.IsDirty("LiqImpDescuentos") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqimpdescuentos = sdt.getgxTv_SdtLiquidacion_Liqimpdescuentos() ;
      }
      if ( sdt.IsDirty("LiqImpRetenGan") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqimpretengan = sdt.getgxTv_SdtLiquidacion_Liqimpretengan() ;
      }
      if ( sdt.IsDirty("LiqImpBruto") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqimpbruto = sdt.getgxTv_SdtLiquidacion_Liqimpbruto() ;
      }
      if ( sdt.IsDirty("LegEspecificos") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Legespecificos = sdt.getgxTv_SdtLiquidacion_Legespecificos() ;
      }
      if ( sdt.IsDirty("LiqFecCre") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqfeccre = sdt.getgxTv_SdtLiquidacion_Liqfeccre() ;
      }
      if ( sdt.IsDirty("LiqUsuCre") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqusucre = sdt.getgxTv_SdtLiquidacion_Liqusucre() ;
      }
      if ( sdt.IsDirty("LiqPerSinDia") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqpersindia = sdt.getgxTv_SdtLiquidacion_Liqpersindia() ;
      }
      if ( sdt.IsDirty("LiqPerPalabra") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqperpalabra = sdt.getgxTv_SdtLiquidacion_Liqperpalabra() ;
      }
      if ( sdt.IsDirty("LiqDepPrvPer") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqdepprvper = sdt.getgxTv_SdtLiquidacion_Liqdepprvper() ;
      }
      if ( sdt.IsDirty("LiqDepPrvFec") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqdepprvfec = sdt.getgxTv_SdtLiquidacion_Liqdepprvfec() ;
      }
      if ( sdt.IsDirty("LiqDepBanDescrip") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqdepbandescrip = sdt.getgxTv_SdtLiquidacion_Liqdepbandescrip() ;
      }
      if ( sdt.IsDirty("LiqDepBanCod") )
      {
         gxTv_SdtLiquidacion_Liqdepbancod_N = sdt.getgxTv_SdtLiquidacion_Liqdepbancod_N() ;
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqdepbancod = sdt.getgxTv_SdtLiquidacion_Liqdepbancod() ;
      }
      if ( sdt.IsDirty("LiqDepPerAno") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqdepperano = sdt.getgxTv_SdtLiquidacion_Liqdepperano() ;
      }
      if ( sdt.IsDirty("LiqDepPerMes") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqdeppermes = sdt.getgxTv_SdtLiquidacion_Liqdeppermes() ;
      }
      if ( sdt.IsDirty("LiqFecMod") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqfecmod = sdt.getgxTv_SdtLiquidacion_Liqfecmod() ;
      }
      if ( sdt.IsDirty("LiqUsuMod") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqusumod = sdt.getgxTv_SdtLiquidacion_Liqusumod() ;
      }
      if ( sdt.IsDirty("LiqFecImp") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqfecimp = sdt.getgxTv_SdtLiquidacion_Liqfecimp() ;
      }
      if ( sdt.IsDirty("LiqPisoGanancias") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqpisoganancias = sdt.getgxTv_SdtLiquidacion_Liqpisoganancias() ;
      }
      if ( sdt.IsDirty("LiqPisGanSAC") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqpisgansac = sdt.getgxTv_SdtLiquidacion_Liqpisgansac() ;
      }
      if ( sdt.IsDirty("LiqTopeDedInc") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqtopededinc = sdt.getgxTv_SdtLiquidacion_Liqtopededinc() ;
      }
      if ( sdt.IsDirty("LiqPerUltNorm") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqperultnorm = sdt.getgxTv_SdtLiquidacion_Liqperultnorm() ;
      }
      if ( sdt.IsDirty("LiqError") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqerror = sdt.getgxTv_SdtLiquidacion_Liqerror() ;
      }
      if ( sdt.IsDirty("LiqErrorAux") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqerroraux = sdt.getgxTv_SdtLiquidacion_Liqerroraux() ;
      }
      if ( sdt.IsDirty("LiqNombre") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqnombre = sdt.getgxTv_SdtLiquidacion_Liqnombre() ;
      }
      if ( sdt.IsDirty("LiqLegajosTxt") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqlegajostxt = sdt.getgxTv_SdtLiquidacion_Liqlegajostxt() ;
      }
      if ( sdt.IsDirty("LiqSegundos") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqsegundos = sdt.getgxTv_SdtLiquidacion_Liqsegundos() ;
      }
      if ( sdt.IsDirty("LiqRutaPDFTodosVertical") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqrutapdftodosvertical = sdt.getgxTv_SdtLiquidacion_Liqrutapdftodosvertical() ;
      }
      if ( sdt.IsDirty("LiqRutaPDFTodosHorizontal") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal = sdt.getgxTv_SdtLiquidacion_Liqrutapdftodoshorizontal() ;
      }
      if ( sdt.IsDirty("LiqRutaPDFTodosNombreVertical") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical = sdt.getgxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical() ;
      }
      if ( sdt.IsDirty("LiqRutaPDFTodosNombreHorizontal") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal = sdt.getgxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal() ;
      }
      if ( sdt.IsDirty("LiqLog") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqlog = sdt.getgxTv_SdtLiquidacion_Liqlog() ;
      }
      if ( sdt.IsDirty("PeriodoLiq") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Periodoliq = sdt.getgxTv_SdtLiquidacion_Periodoliq() ;
      }
      if ( sdt.IsDirty("LiqRelNro") )
      {
         gxTv_SdtLiquidacion_Liqrelnro_N = sdt.getgxTv_SdtLiquidacion_Liqrelnro_N() ;
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqrelnro = sdt.getgxTv_SdtLiquidacion_Liqrelnro() ;
      }
      if ( sdt.IsDirty("LiqSac") )
      {
         gxTv_SdtLiquidacion_Liqsac_N = sdt.getgxTv_SdtLiquidacion_Liqsac_N() ;
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqsac = sdt.getgxTv_SdtLiquidacion_Liqsac() ;
      }
      if ( sdt.IsDirty("LiqSacLog") )
      {
         gxTv_SdtLiquidacion_Liqsaclog_N = sdt.getgxTv_SdtLiquidacion_Liqsaclog_N() ;
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqsaclog = sdt.getgxTv_SdtLiquidacion_Liqsaclog() ;
      }
      if ( sdt.IsDirty("LiqCancel") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqcancel = sdt.getgxTv_SdtLiquidacion_Liqcancel() ;
      }
      if ( sdt.IsDirty("LiqModTra") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqmodtra = sdt.getgxTv_SdtLiquidacion_Liqmodtra() ;
      }
      if ( sdt.IsDirty("LiqFrecPag") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqfrecpag = sdt.getgxTv_SdtLiquidacion_Liqfrecpag() ;
      }
      if ( sdt.IsDirty("LiqPerDes") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqperdes = sdt.getgxTv_SdtLiquidacion_Liqperdes() ;
      }
      if ( sdt.IsDirty("LiqPerHas") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqperhas = sdt.getgxTv_SdtLiquidacion_Liqperhas() ;
      }
      if ( sdt.IsDirty("LiqTipoTarifa") )
      {
         gxTv_SdtLiquidacion_N = (byte)(0) ;
         gxTv_SdtLiquidacion_Liqtipotarifa = sdt.getgxTv_SdtLiquidacion_Liqtipotarifa() ;
      }
   }

   public int getgxTv_SdtLiquidacion_Clicod( )
   {
      return gxTv_SdtLiquidacion_Clicod ;
   }

   public void setgxTv_SdtLiquidacion_Clicod( int value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      if ( gxTv_SdtLiquidacion_Clicod != value )
      {
         gxTv_SdtLiquidacion_Mode = "INS" ;
         this.setgxTv_SdtLiquidacion_Clicod_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Empcod_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Empnom_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqnro_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdescrip_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqfecha_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqperano_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqpermes_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqperiodo_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqfecpago_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Tliqcod_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Tliqdesc_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Tliqdescaux_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqestado_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqlsddepest_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqauxestado_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqcontrest_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqclase_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqpdfestado_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqgeninter_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqcontabilizada_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqcntleg_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqimpneto_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqimpdescuentos_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqimpretengan_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqimpbruto_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Legespecificos_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqfeccre_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqusucre_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqpersindia_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqperpalabra_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdepprvper_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdepprvfec_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdepbandescrip_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdepbancod_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdepperano_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdeppermes_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqfecmod_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqusumod_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqfecimp_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqpisoganancias_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqpisgansac_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqtopededinc_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqperultnorm_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqerror_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqerroraux_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqnombre_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqlegajostxt_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqsegundos_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Periodoliq_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqrelnro_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqsac_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqsaclog_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqcancel_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqmodtra_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqfrecpag_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqperdes_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqperhas_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqtipotarifa_Z_SetNull( );
      }
      SetDirty("Clicod");
      gxTv_SdtLiquidacion_Clicod = value ;
   }

   public short getgxTv_SdtLiquidacion_Empcod( )
   {
      return gxTv_SdtLiquidacion_Empcod ;
   }

   public void setgxTv_SdtLiquidacion_Empcod( short value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      if ( gxTv_SdtLiquidacion_Empcod != value )
      {
         gxTv_SdtLiquidacion_Mode = "INS" ;
         this.setgxTv_SdtLiquidacion_Clicod_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Empcod_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Empnom_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqnro_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdescrip_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqfecha_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqperano_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqpermes_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqperiodo_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqfecpago_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Tliqcod_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Tliqdesc_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Tliqdescaux_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqestado_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqlsddepest_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqauxestado_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqcontrest_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqclase_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqpdfestado_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqgeninter_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqcontabilizada_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqcntleg_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqimpneto_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqimpdescuentos_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqimpretengan_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqimpbruto_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Legespecificos_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqfeccre_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqusucre_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqpersindia_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqperpalabra_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdepprvper_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdepprvfec_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdepbandescrip_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdepbancod_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdepperano_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdeppermes_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqfecmod_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqusumod_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqfecimp_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqpisoganancias_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqpisgansac_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqtopededinc_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqperultnorm_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqerror_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqerroraux_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqnombre_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqlegajostxt_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqsegundos_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Periodoliq_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqrelnro_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqsac_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqsaclog_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqcancel_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqmodtra_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqfrecpag_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqperdes_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqperhas_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqtipotarifa_Z_SetNull( );
      }
      SetDirty("Empcod");
      gxTv_SdtLiquidacion_Empcod = value ;
   }

   public String getgxTv_SdtLiquidacion_Empnom( )
   {
      return gxTv_SdtLiquidacion_Empnom ;
   }

   public void setgxTv_SdtLiquidacion_Empnom( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Empnom");
      gxTv_SdtLiquidacion_Empnom = value ;
   }

   public int getgxTv_SdtLiquidacion_Liqnro( )
   {
      return gxTv_SdtLiquidacion_Liqnro ;
   }

   public void setgxTv_SdtLiquidacion_Liqnro( int value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      if ( gxTv_SdtLiquidacion_Liqnro != value )
      {
         gxTv_SdtLiquidacion_Mode = "INS" ;
         this.setgxTv_SdtLiquidacion_Clicod_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Empcod_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Empnom_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqnro_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdescrip_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqfecha_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqperano_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqpermes_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqperiodo_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqfecpago_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Tliqcod_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Tliqdesc_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Tliqdescaux_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqestado_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqlsddepest_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqauxestado_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqcontrest_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqclase_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqpdfestado_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqgeninter_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqcontabilizada_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqcntleg_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqimpneto_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqimpdescuentos_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqimpretengan_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqimpbruto_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Legespecificos_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqfeccre_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqusucre_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqpersindia_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqperpalabra_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdepprvper_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdepprvfec_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdepbandescrip_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdepbancod_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdepperano_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqdeppermes_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqfecmod_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqusumod_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqfecimp_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqpisoganancias_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqpisgansac_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqtopededinc_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqperultnorm_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqerror_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqerroraux_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqnombre_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqlegajostxt_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqsegundos_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Periodoliq_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqrelnro_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqsac_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqsaclog_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqcancel_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqmodtra_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqfrecpag_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqperdes_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqperhas_Z_SetNull( );
         this.setgxTv_SdtLiquidacion_Liqtipotarifa_Z_SetNull( );
      }
      SetDirty("Liqnro");
      gxTv_SdtLiquidacion_Liqnro = value ;
   }

   public String getgxTv_SdtLiquidacion_Liqdescrip( )
   {
      return gxTv_SdtLiquidacion_Liqdescrip ;
   }

   public void setgxTv_SdtLiquidacion_Liqdescrip( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqdescrip");
      gxTv_SdtLiquidacion_Liqdescrip = value ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqfecha( )
   {
      return gxTv_SdtLiquidacion_Liqfecha ;
   }

   public void setgxTv_SdtLiquidacion_Liqfecha( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqfecha");
      gxTv_SdtLiquidacion_Liqfecha = value ;
   }

   public short getgxTv_SdtLiquidacion_Liqperano( )
   {
      return gxTv_SdtLiquidacion_Liqperano ;
   }

   public void setgxTv_SdtLiquidacion_Liqperano( short value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqperano");
      gxTv_SdtLiquidacion_Liqperano = value ;
   }

   public byte getgxTv_SdtLiquidacion_Liqpermes( )
   {
      return gxTv_SdtLiquidacion_Liqpermes ;
   }

   public void setgxTv_SdtLiquidacion_Liqpermes( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqpermes");
      gxTv_SdtLiquidacion_Liqpermes = value ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqperiodo( )
   {
      return gxTv_SdtLiquidacion_Liqperiodo ;
   }

   public void setgxTv_SdtLiquidacion_Liqperiodo( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqperiodo");
      gxTv_SdtLiquidacion_Liqperiodo = value ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqfecpago( )
   {
      return gxTv_SdtLiquidacion_Liqfecpago ;
   }

   public void setgxTv_SdtLiquidacion_Liqfecpago( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqfecpago");
      gxTv_SdtLiquidacion_Liqfecpago = value ;
   }

   public String getgxTv_SdtLiquidacion_Tliqcod( )
   {
      return gxTv_SdtLiquidacion_Tliqcod ;
   }

   public void setgxTv_SdtLiquidacion_Tliqcod( String value )
   {
      gxTv_SdtLiquidacion_Tliqcod_N = (byte)(0) ;
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqcod");
      gxTv_SdtLiquidacion_Tliqcod = value ;
   }

   public void setgxTv_SdtLiquidacion_Tliqcod_SetNull( )
   {
      gxTv_SdtLiquidacion_Tliqcod_N = (byte)(1) ;
      gxTv_SdtLiquidacion_Tliqcod = "" ;
      SetDirty("Tliqcod");
   }

   public boolean getgxTv_SdtLiquidacion_Tliqcod_IsNull( )
   {
      return (gxTv_SdtLiquidacion_Tliqcod_N==1) ;
   }

   public String getgxTv_SdtLiquidacion_Tliqdesc( )
   {
      return gxTv_SdtLiquidacion_Tliqdesc ;
   }

   public void setgxTv_SdtLiquidacion_Tliqdesc( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqdesc");
      gxTv_SdtLiquidacion_Tliqdesc = value ;
   }

   public String getgxTv_SdtLiquidacion_Tliqdescaux( )
   {
      return gxTv_SdtLiquidacion_Tliqdescaux ;
   }

   public void setgxTv_SdtLiquidacion_Tliqdescaux( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqdescaux");
      gxTv_SdtLiquidacion_Tliqdescaux = value ;
   }

   public byte getgxTv_SdtLiquidacion_Liqestado( )
   {
      return gxTv_SdtLiquidacion_Liqestado ;
   }

   public void setgxTv_SdtLiquidacion_Liqestado( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqestado");
      gxTv_SdtLiquidacion_Liqestado = value ;
   }

   public byte getgxTv_SdtLiquidacion_Liqlsddepest( )
   {
      return gxTv_SdtLiquidacion_Liqlsddepest ;
   }

   public void setgxTv_SdtLiquidacion_Liqlsddepest( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqlsddepest");
      gxTv_SdtLiquidacion_Liqlsddepest = value ;
   }

   public byte getgxTv_SdtLiquidacion_Liqauxestado( )
   {
      return gxTv_SdtLiquidacion_Liqauxestado ;
   }

   public void setgxTv_SdtLiquidacion_Liqauxestado( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqauxestado");
      gxTv_SdtLiquidacion_Liqauxestado = value ;
   }

   public byte getgxTv_SdtLiquidacion_Liqcontrest( )
   {
      return gxTv_SdtLiquidacion_Liqcontrest ;
   }

   public void setgxTv_SdtLiquidacion_Liqcontrest( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqcontrest");
      gxTv_SdtLiquidacion_Liqcontrest = value ;
   }

   public byte getgxTv_SdtLiquidacion_Liqclase( )
   {
      return gxTv_SdtLiquidacion_Liqclase ;
   }

   public void setgxTv_SdtLiquidacion_Liqclase( byte value )
   {
      gxTv_SdtLiquidacion_Liqclase_N = (byte)(0) ;
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqclase");
      gxTv_SdtLiquidacion_Liqclase = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqclase_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqclase_N = (byte)(1) ;
      gxTv_SdtLiquidacion_Liqclase = (byte)(0) ;
      SetDirty("Liqclase");
   }

   public boolean getgxTv_SdtLiquidacion_Liqclase_IsNull( )
   {
      return (gxTv_SdtLiquidacion_Liqclase_N==1) ;
   }

   public String getgxTv_SdtLiquidacion_Liqpdfestado( )
   {
      return gxTv_SdtLiquidacion_Liqpdfestado ;
   }

   public void setgxTv_SdtLiquidacion_Liqpdfestado( String value )
   {
      gxTv_SdtLiquidacion_Liqpdfestado_N = (byte)(0) ;
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqpdfestado");
      gxTv_SdtLiquidacion_Liqpdfestado = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqpdfestado_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqpdfestado_N = (byte)(1) ;
      gxTv_SdtLiquidacion_Liqpdfestado = "" ;
      SetDirty("Liqpdfestado");
   }

   public boolean getgxTv_SdtLiquidacion_Liqpdfestado_IsNull( )
   {
      return (gxTv_SdtLiquidacion_Liqpdfestado_N==1) ;
   }

   public boolean getgxTv_SdtLiquidacion_Liqgeninter( )
   {
      return gxTv_SdtLiquidacion_Liqgeninter ;
   }

   public void setgxTv_SdtLiquidacion_Liqgeninter( boolean value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqgeninter");
      gxTv_SdtLiquidacion_Liqgeninter = value ;
   }

   public boolean getgxTv_SdtLiquidacion_Liqcontabilizada( )
   {
      return gxTv_SdtLiquidacion_Liqcontabilizada ;
   }

   public void setgxTv_SdtLiquidacion_Liqcontabilizada( boolean value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqcontabilizada");
      gxTv_SdtLiquidacion_Liqcontabilizada = value ;
   }

   public short getgxTv_SdtLiquidacion_Liqcntleg( )
   {
      return gxTv_SdtLiquidacion_Liqcntleg ;
   }

   public void setgxTv_SdtLiquidacion_Liqcntleg( short value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqcntleg");
      gxTv_SdtLiquidacion_Liqcntleg = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacion_Liqimpneto( )
   {
      return gxTv_SdtLiquidacion_Liqimpneto ;
   }

   public void setgxTv_SdtLiquidacion_Liqimpneto( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqimpneto");
      gxTv_SdtLiquidacion_Liqimpneto = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacion_Liqimpdescuentos( )
   {
      return gxTv_SdtLiquidacion_Liqimpdescuentos ;
   }

   public void setgxTv_SdtLiquidacion_Liqimpdescuentos( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqimpdescuentos");
      gxTv_SdtLiquidacion_Liqimpdescuentos = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacion_Liqimpretengan( )
   {
      return gxTv_SdtLiquidacion_Liqimpretengan ;
   }

   public void setgxTv_SdtLiquidacion_Liqimpretengan( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqimpretengan");
      gxTv_SdtLiquidacion_Liqimpretengan = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacion_Liqimpbruto( )
   {
      return gxTv_SdtLiquidacion_Liqimpbruto ;
   }

   public void setgxTv_SdtLiquidacion_Liqimpbruto( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqimpbruto");
      gxTv_SdtLiquidacion_Liqimpbruto = value ;
   }

   public boolean getgxTv_SdtLiquidacion_Legespecificos( )
   {
      return gxTv_SdtLiquidacion_Legespecificos ;
   }

   public void setgxTv_SdtLiquidacion_Legespecificos( boolean value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Legespecificos");
      gxTv_SdtLiquidacion_Legespecificos = value ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqfeccre( )
   {
      return gxTv_SdtLiquidacion_Liqfeccre ;
   }

   public void setgxTv_SdtLiquidacion_Liqfeccre( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqfeccre");
      gxTv_SdtLiquidacion_Liqfeccre = value ;
   }

   public String getgxTv_SdtLiquidacion_Liqusucre( )
   {
      return gxTv_SdtLiquidacion_Liqusucre ;
   }

   public void setgxTv_SdtLiquidacion_Liqusucre( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqusucre");
      gxTv_SdtLiquidacion_Liqusucre = value ;
   }

   public String getgxTv_SdtLiquidacion_Liqpersindia( )
   {
      return gxTv_SdtLiquidacion_Liqpersindia ;
   }

   public void setgxTv_SdtLiquidacion_Liqpersindia( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqpersindia");
      gxTv_SdtLiquidacion_Liqpersindia = value ;
   }

   public String getgxTv_SdtLiquidacion_Liqperpalabra( )
   {
      return gxTv_SdtLiquidacion_Liqperpalabra ;
   }

   public void setgxTv_SdtLiquidacion_Liqperpalabra( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqperpalabra");
      gxTv_SdtLiquidacion_Liqperpalabra = value ;
   }

   public String getgxTv_SdtLiquidacion_Liqdepprvper( )
   {
      return gxTv_SdtLiquidacion_Liqdepprvper ;
   }

   public void setgxTv_SdtLiquidacion_Liqdepprvper( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqdepprvper");
      gxTv_SdtLiquidacion_Liqdepprvper = value ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqdepprvfec( )
   {
      return gxTv_SdtLiquidacion_Liqdepprvfec ;
   }

   public void setgxTv_SdtLiquidacion_Liqdepprvfec( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqdepprvfec");
      gxTv_SdtLiquidacion_Liqdepprvfec = value ;
   }

   public String getgxTv_SdtLiquidacion_Liqdepbandescrip( )
   {
      return gxTv_SdtLiquidacion_Liqdepbandescrip ;
   }

   public void setgxTv_SdtLiquidacion_Liqdepbandescrip( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqdepbandescrip");
      gxTv_SdtLiquidacion_Liqdepbandescrip = value ;
   }

   public String getgxTv_SdtLiquidacion_Liqdepbancod( )
   {
      return gxTv_SdtLiquidacion_Liqdepbancod ;
   }

   public void setgxTv_SdtLiquidacion_Liqdepbancod( String value )
   {
      gxTv_SdtLiquidacion_Liqdepbancod_N = (byte)(0) ;
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqdepbancod");
      gxTv_SdtLiquidacion_Liqdepbancod = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqdepbancod_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqdepbancod_N = (byte)(1) ;
      gxTv_SdtLiquidacion_Liqdepbancod = "" ;
      SetDirty("Liqdepbancod");
   }

   public boolean getgxTv_SdtLiquidacion_Liqdepbancod_IsNull( )
   {
      return (gxTv_SdtLiquidacion_Liqdepbancod_N==1) ;
   }

   public short getgxTv_SdtLiquidacion_Liqdepperano( )
   {
      return gxTv_SdtLiquidacion_Liqdepperano ;
   }

   public void setgxTv_SdtLiquidacion_Liqdepperano( short value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqdepperano");
      gxTv_SdtLiquidacion_Liqdepperano = value ;
   }

   public byte getgxTv_SdtLiquidacion_Liqdeppermes( )
   {
      return gxTv_SdtLiquidacion_Liqdeppermes ;
   }

   public void setgxTv_SdtLiquidacion_Liqdeppermes( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqdeppermes");
      gxTv_SdtLiquidacion_Liqdeppermes = value ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqfecmod( )
   {
      return gxTv_SdtLiquidacion_Liqfecmod ;
   }

   public void setgxTv_SdtLiquidacion_Liqfecmod( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqfecmod");
      gxTv_SdtLiquidacion_Liqfecmod = value ;
   }

   public String getgxTv_SdtLiquidacion_Liqusumod( )
   {
      return gxTv_SdtLiquidacion_Liqusumod ;
   }

   public void setgxTv_SdtLiquidacion_Liqusumod( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqusumod");
      gxTv_SdtLiquidacion_Liqusumod = value ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqfecimp( )
   {
      return gxTv_SdtLiquidacion_Liqfecimp ;
   }

   public void setgxTv_SdtLiquidacion_Liqfecimp( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqfecimp");
      gxTv_SdtLiquidacion_Liqfecimp = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacion_Liqpisoganancias( )
   {
      return gxTv_SdtLiquidacion_Liqpisoganancias ;
   }

   public void setgxTv_SdtLiquidacion_Liqpisoganancias( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqpisoganancias");
      gxTv_SdtLiquidacion_Liqpisoganancias = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacion_Liqpisgansac( )
   {
      return gxTv_SdtLiquidacion_Liqpisgansac ;
   }

   public void setgxTv_SdtLiquidacion_Liqpisgansac( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqpisgansac");
      gxTv_SdtLiquidacion_Liqpisgansac = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacion_Liqtopededinc( )
   {
      return gxTv_SdtLiquidacion_Liqtopededinc ;
   }

   public void setgxTv_SdtLiquidacion_Liqtopededinc( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqtopededinc");
      gxTv_SdtLiquidacion_Liqtopededinc = value ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqperultnorm( )
   {
      return gxTv_SdtLiquidacion_Liqperultnorm ;
   }

   public void setgxTv_SdtLiquidacion_Liqperultnorm( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqperultnorm");
      gxTv_SdtLiquidacion_Liqperultnorm = value ;
   }

   public String getgxTv_SdtLiquidacion_Liqerror( )
   {
      return gxTv_SdtLiquidacion_Liqerror ;
   }

   public void setgxTv_SdtLiquidacion_Liqerror( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqerror");
      gxTv_SdtLiquidacion_Liqerror = value ;
   }

   public String getgxTv_SdtLiquidacion_Liqerroraux( )
   {
      return gxTv_SdtLiquidacion_Liqerroraux ;
   }

   public void setgxTv_SdtLiquidacion_Liqerroraux( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqerroraux");
      gxTv_SdtLiquidacion_Liqerroraux = value ;
   }

   public String getgxTv_SdtLiquidacion_Liqnombre( )
   {
      return gxTv_SdtLiquidacion_Liqnombre ;
   }

   public void setgxTv_SdtLiquidacion_Liqnombre( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqnombre");
      gxTv_SdtLiquidacion_Liqnombre = value ;
   }

   public String getgxTv_SdtLiquidacion_Liqlegajostxt( )
   {
      return gxTv_SdtLiquidacion_Liqlegajostxt ;
   }

   public void setgxTv_SdtLiquidacion_Liqlegajostxt( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqlegajostxt");
      gxTv_SdtLiquidacion_Liqlegajostxt = value ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacion_Liqsegundos( )
   {
      return gxTv_SdtLiquidacion_Liqsegundos ;
   }

   public void setgxTv_SdtLiquidacion_Liqsegundos( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqsegundos");
      gxTv_SdtLiquidacion_Liqsegundos = value ;
   }

   public String getgxTv_SdtLiquidacion_Liqrutapdftodosvertical( )
   {
      return gxTv_SdtLiquidacion_Liqrutapdftodosvertical ;
   }

   public void setgxTv_SdtLiquidacion_Liqrutapdftodosvertical( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqrutapdftodosvertical");
      gxTv_SdtLiquidacion_Liqrutapdftodosvertical = value ;
   }

   public String getgxTv_SdtLiquidacion_Liqrutapdftodoshorizontal( )
   {
      return gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal ;
   }

   public void setgxTv_SdtLiquidacion_Liqrutapdftodoshorizontal( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqrutapdftodoshorizontal");
      gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal = value ;
   }

   public String getgxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical( )
   {
      return gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical ;
   }

   public void setgxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqrutapdftodosnombrevertical");
      gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical = value ;
   }

   public String getgxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal( )
   {
      return gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal ;
   }

   public void setgxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqrutapdftodosnombrehorizontal");
      gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal = value ;
   }

   public String getgxTv_SdtLiquidacion_Liqlog( )
   {
      return gxTv_SdtLiquidacion_Liqlog ;
   }

   public void setgxTv_SdtLiquidacion_Liqlog( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqlog");
      gxTv_SdtLiquidacion_Liqlog = value ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Periodoliq( )
   {
      return gxTv_SdtLiquidacion_Periodoliq ;
   }

   public void setgxTv_SdtLiquidacion_Periodoliq( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Periodoliq");
      gxTv_SdtLiquidacion_Periodoliq = value ;
   }

   public int getgxTv_SdtLiquidacion_Liqrelnro( )
   {
      return gxTv_SdtLiquidacion_Liqrelnro ;
   }

   public void setgxTv_SdtLiquidacion_Liqrelnro( int value )
   {
      gxTv_SdtLiquidacion_Liqrelnro_N = (byte)(0) ;
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqrelnro");
      gxTv_SdtLiquidacion_Liqrelnro = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqrelnro_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqrelnro_N = (byte)(1) ;
      gxTv_SdtLiquidacion_Liqrelnro = 0 ;
      SetDirty("Liqrelnro");
   }

   public boolean getgxTv_SdtLiquidacion_Liqrelnro_IsNull( )
   {
      return (gxTv_SdtLiquidacion_Liqrelnro_N==1) ;
   }

   public boolean getgxTv_SdtLiquidacion_Liqsac( )
   {
      return gxTv_SdtLiquidacion_Liqsac ;
   }

   public void setgxTv_SdtLiquidacion_Liqsac( boolean value )
   {
      gxTv_SdtLiquidacion_Liqsac_N = (byte)(0) ;
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqsac");
      gxTv_SdtLiquidacion_Liqsac = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqsac_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqsac_N = (byte)(1) ;
      gxTv_SdtLiquidacion_Liqsac = false ;
      SetDirty("Liqsac");
   }

   public boolean getgxTv_SdtLiquidacion_Liqsac_IsNull( )
   {
      return (gxTv_SdtLiquidacion_Liqsac_N==1) ;
   }

   public String getgxTv_SdtLiquidacion_Liqsaclog( )
   {
      return gxTv_SdtLiquidacion_Liqsaclog ;
   }

   public void setgxTv_SdtLiquidacion_Liqsaclog( String value )
   {
      gxTv_SdtLiquidacion_Liqsaclog_N = (byte)(0) ;
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqsaclog");
      gxTv_SdtLiquidacion_Liqsaclog = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqsaclog_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqsaclog_N = (byte)(1) ;
      gxTv_SdtLiquidacion_Liqsaclog = "" ;
      SetDirty("Liqsaclog");
   }

   public boolean getgxTv_SdtLiquidacion_Liqsaclog_IsNull( )
   {
      return (gxTv_SdtLiquidacion_Liqsaclog_N==1) ;
   }

   public boolean getgxTv_SdtLiquidacion_Liqcancel( )
   {
      return gxTv_SdtLiquidacion_Liqcancel ;
   }

   public void setgxTv_SdtLiquidacion_Liqcancel( boolean value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqcancel");
      gxTv_SdtLiquidacion_Liqcancel = value ;
   }

   public String getgxTv_SdtLiquidacion_Liqmodtra( )
   {
      return gxTv_SdtLiquidacion_Liqmodtra ;
   }

   public void setgxTv_SdtLiquidacion_Liqmodtra( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqmodtra");
      gxTv_SdtLiquidacion_Liqmodtra = value ;
   }

   public byte getgxTv_SdtLiquidacion_Liqfrecpag( )
   {
      return gxTv_SdtLiquidacion_Liqfrecpag ;
   }

   public void setgxTv_SdtLiquidacion_Liqfrecpag( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqfrecpag");
      gxTv_SdtLiquidacion_Liqfrecpag = value ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqperdes( )
   {
      return gxTv_SdtLiquidacion_Liqperdes ;
   }

   public void setgxTv_SdtLiquidacion_Liqperdes( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqperdes");
      gxTv_SdtLiquidacion_Liqperdes = value ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqperhas( )
   {
      return gxTv_SdtLiquidacion_Liqperhas ;
   }

   public void setgxTv_SdtLiquidacion_Liqperhas( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqperhas");
      gxTv_SdtLiquidacion_Liqperhas = value ;
   }

   public String getgxTv_SdtLiquidacion_Liqtipotarifa( )
   {
      return gxTv_SdtLiquidacion_Liqtipotarifa ;
   }

   public void setgxTv_SdtLiquidacion_Liqtipotarifa( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqtipotarifa");
      gxTv_SdtLiquidacion_Liqtipotarifa = value ;
   }

   public String getgxTv_SdtLiquidacion_Mode( )
   {
      return gxTv_SdtLiquidacion_Mode ;
   }

   public void setgxTv_SdtLiquidacion_Mode( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtLiquidacion_Mode = value ;
   }

   public void setgxTv_SdtLiquidacion_Mode_SetNull( )
   {
      gxTv_SdtLiquidacion_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtLiquidacion_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLiquidacion_Initialized( )
   {
      return gxTv_SdtLiquidacion_Initialized ;
   }

   public void setgxTv_SdtLiquidacion_Initialized( short value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtLiquidacion_Initialized = value ;
   }

   public void setgxTv_SdtLiquidacion_Initialized_SetNull( )
   {
      gxTv_SdtLiquidacion_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtLiquidacion_Initialized_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtLiquidacion_Clicod_Z( )
   {
      return gxTv_SdtLiquidacion_Clicod_Z ;
   }

   public void setgxTv_SdtLiquidacion_Clicod_Z( int value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Clicod_Z");
      gxTv_SdtLiquidacion_Clicod_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Clicod_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Clicod_Z = 0 ;
      SetDirty("Clicod_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Clicod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLiquidacion_Empcod_Z( )
   {
      return gxTv_SdtLiquidacion_Empcod_Z ;
   }

   public void setgxTv_SdtLiquidacion_Empcod_Z( short value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Empcod_Z");
      gxTv_SdtLiquidacion_Empcod_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Empcod_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Empcod_Z = (short)(0) ;
      SetDirty("Empcod_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Empcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Empnom_Z( )
   {
      return gxTv_SdtLiquidacion_Empnom_Z ;
   }

   public void setgxTv_SdtLiquidacion_Empnom_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Empnom_Z");
      gxTv_SdtLiquidacion_Empnom_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Empnom_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Empnom_Z = "" ;
      SetDirty("Empnom_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Empnom_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtLiquidacion_Liqnro_Z( )
   {
      return gxTv_SdtLiquidacion_Liqnro_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqnro_Z( int value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqnro_Z");
      gxTv_SdtLiquidacion_Liqnro_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqnro_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqnro_Z = 0 ;
      SetDirty("Liqnro_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqnro_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqdescrip_Z( )
   {
      return gxTv_SdtLiquidacion_Liqdescrip_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqdescrip_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqdescrip_Z");
      gxTv_SdtLiquidacion_Liqdescrip_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqdescrip_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqdescrip_Z = "" ;
      SetDirty("Liqdescrip_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqdescrip_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqfecha_Z( )
   {
      return gxTv_SdtLiquidacion_Liqfecha_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqfecha_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqfecha_Z");
      gxTv_SdtLiquidacion_Liqfecha_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqfecha_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqfecha_Z = GXutil.nullDate() ;
      SetDirty("Liqfecha_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqfecha_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLiquidacion_Liqperano_Z( )
   {
      return gxTv_SdtLiquidacion_Liqperano_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqperano_Z( short value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqperano_Z");
      gxTv_SdtLiquidacion_Liqperano_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqperano_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqperano_Z = (short)(0) ;
      SetDirty("Liqperano_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqperano_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacion_Liqpermes_Z( )
   {
      return gxTv_SdtLiquidacion_Liqpermes_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqpermes_Z( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqpermes_Z");
      gxTv_SdtLiquidacion_Liqpermes_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqpermes_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqpermes_Z = (byte)(0) ;
      SetDirty("Liqpermes_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqpermes_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqperiodo_Z( )
   {
      return gxTv_SdtLiquidacion_Liqperiodo_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqperiodo_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqperiodo_Z");
      gxTv_SdtLiquidacion_Liqperiodo_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqperiodo_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqperiodo_Z = GXutil.nullDate() ;
      SetDirty("Liqperiodo_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqperiodo_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqfecpago_Z( )
   {
      return gxTv_SdtLiquidacion_Liqfecpago_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqfecpago_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqfecpago_Z");
      gxTv_SdtLiquidacion_Liqfecpago_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqfecpago_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqfecpago_Z = GXutil.nullDate() ;
      SetDirty("Liqfecpago_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqfecpago_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Tliqcod_Z( )
   {
      return gxTv_SdtLiquidacion_Tliqcod_Z ;
   }

   public void setgxTv_SdtLiquidacion_Tliqcod_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqcod_Z");
      gxTv_SdtLiquidacion_Tliqcod_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Tliqcod_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Tliqcod_Z = "" ;
      SetDirty("Tliqcod_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Tliqcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Tliqdesc_Z( )
   {
      return gxTv_SdtLiquidacion_Tliqdesc_Z ;
   }

   public void setgxTv_SdtLiquidacion_Tliqdesc_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqdesc_Z");
      gxTv_SdtLiquidacion_Tliqdesc_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Tliqdesc_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Tliqdesc_Z = "" ;
      SetDirty("Tliqdesc_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Tliqdesc_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Tliqdescaux_Z( )
   {
      return gxTv_SdtLiquidacion_Tliqdescaux_Z ;
   }

   public void setgxTv_SdtLiquidacion_Tliqdescaux_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqdescaux_Z");
      gxTv_SdtLiquidacion_Tliqdescaux_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Tliqdescaux_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Tliqdescaux_Z = "" ;
      SetDirty("Tliqdescaux_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Tliqdescaux_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacion_Liqestado_Z( )
   {
      return gxTv_SdtLiquidacion_Liqestado_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqestado_Z( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqestado_Z");
      gxTv_SdtLiquidacion_Liqestado_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqestado_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqestado_Z = (byte)(0) ;
      SetDirty("Liqestado_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqestado_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacion_Liqlsddepest_Z( )
   {
      return gxTv_SdtLiquidacion_Liqlsddepest_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqlsddepest_Z( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqlsddepest_Z");
      gxTv_SdtLiquidacion_Liqlsddepest_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqlsddepest_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqlsddepest_Z = (byte)(0) ;
      SetDirty("Liqlsddepest_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqlsddepest_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacion_Liqauxestado_Z( )
   {
      return gxTv_SdtLiquidacion_Liqauxestado_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqauxestado_Z( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqauxestado_Z");
      gxTv_SdtLiquidacion_Liqauxestado_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqauxestado_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqauxestado_Z = (byte)(0) ;
      SetDirty("Liqauxestado_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqauxestado_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacion_Liqcontrest_Z( )
   {
      return gxTv_SdtLiquidacion_Liqcontrest_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqcontrest_Z( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqcontrest_Z");
      gxTv_SdtLiquidacion_Liqcontrest_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqcontrest_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqcontrest_Z = (byte)(0) ;
      SetDirty("Liqcontrest_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqcontrest_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacion_Liqclase_Z( )
   {
      return gxTv_SdtLiquidacion_Liqclase_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqclase_Z( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqclase_Z");
      gxTv_SdtLiquidacion_Liqclase_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqclase_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqclase_Z = (byte)(0) ;
      SetDirty("Liqclase_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqclase_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqpdfestado_Z( )
   {
      return gxTv_SdtLiquidacion_Liqpdfestado_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqpdfestado_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqpdfestado_Z");
      gxTv_SdtLiquidacion_Liqpdfestado_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqpdfestado_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqpdfestado_Z = "" ;
      SetDirty("Liqpdfestado_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqpdfestado_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLiquidacion_Liqgeninter_Z( )
   {
      return gxTv_SdtLiquidacion_Liqgeninter_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqgeninter_Z( boolean value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqgeninter_Z");
      gxTv_SdtLiquidacion_Liqgeninter_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqgeninter_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqgeninter_Z = false ;
      SetDirty("Liqgeninter_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqgeninter_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLiquidacion_Liqcontabilizada_Z( )
   {
      return gxTv_SdtLiquidacion_Liqcontabilizada_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqcontabilizada_Z( boolean value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqcontabilizada_Z");
      gxTv_SdtLiquidacion_Liqcontabilizada_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqcontabilizada_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqcontabilizada_Z = false ;
      SetDirty("Liqcontabilizada_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqcontabilizada_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLiquidacion_Liqcntleg_Z( )
   {
      return gxTv_SdtLiquidacion_Liqcntleg_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqcntleg_Z( short value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqcntleg_Z");
      gxTv_SdtLiquidacion_Liqcntleg_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqcntleg_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqcntleg_Z = (short)(0) ;
      SetDirty("Liqcntleg_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqcntleg_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacion_Liqimpneto_Z( )
   {
      return gxTv_SdtLiquidacion_Liqimpneto_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqimpneto_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqimpneto_Z");
      gxTv_SdtLiquidacion_Liqimpneto_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqimpneto_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqimpneto_Z = DecimalUtil.ZERO ;
      SetDirty("Liqimpneto_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqimpneto_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacion_Liqimpdescuentos_Z( )
   {
      return gxTv_SdtLiquidacion_Liqimpdescuentos_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqimpdescuentos_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqimpdescuentos_Z");
      gxTv_SdtLiquidacion_Liqimpdescuentos_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqimpdescuentos_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqimpdescuentos_Z = DecimalUtil.ZERO ;
      SetDirty("Liqimpdescuentos_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqimpdescuentos_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacion_Liqimpretengan_Z( )
   {
      return gxTv_SdtLiquidacion_Liqimpretengan_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqimpretengan_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqimpretengan_Z");
      gxTv_SdtLiquidacion_Liqimpretengan_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqimpretengan_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqimpretengan_Z = DecimalUtil.ZERO ;
      SetDirty("Liqimpretengan_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqimpretengan_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacion_Liqimpbruto_Z( )
   {
      return gxTv_SdtLiquidacion_Liqimpbruto_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqimpbruto_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqimpbruto_Z");
      gxTv_SdtLiquidacion_Liqimpbruto_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqimpbruto_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqimpbruto_Z = DecimalUtil.ZERO ;
      SetDirty("Liqimpbruto_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqimpbruto_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLiquidacion_Legespecificos_Z( )
   {
      return gxTv_SdtLiquidacion_Legespecificos_Z ;
   }

   public void setgxTv_SdtLiquidacion_Legespecificos_Z( boolean value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Legespecificos_Z");
      gxTv_SdtLiquidacion_Legespecificos_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Legespecificos_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Legespecificos_Z = false ;
      SetDirty("Legespecificos_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Legespecificos_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqfeccre_Z( )
   {
      return gxTv_SdtLiquidacion_Liqfeccre_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqfeccre_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqfeccre_Z");
      gxTv_SdtLiquidacion_Liqfeccre_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqfeccre_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqfeccre_Z = GXutil.nullDate() ;
      SetDirty("Liqfeccre_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqfeccre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqusucre_Z( )
   {
      return gxTv_SdtLiquidacion_Liqusucre_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqusucre_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqusucre_Z");
      gxTv_SdtLiquidacion_Liqusucre_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqusucre_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqusucre_Z = "" ;
      SetDirty("Liqusucre_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqusucre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqpersindia_Z( )
   {
      return gxTv_SdtLiquidacion_Liqpersindia_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqpersindia_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqpersindia_Z");
      gxTv_SdtLiquidacion_Liqpersindia_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqpersindia_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqpersindia_Z = "" ;
      SetDirty("Liqpersindia_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqpersindia_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqperpalabra_Z( )
   {
      return gxTv_SdtLiquidacion_Liqperpalabra_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqperpalabra_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqperpalabra_Z");
      gxTv_SdtLiquidacion_Liqperpalabra_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqperpalabra_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqperpalabra_Z = "" ;
      SetDirty("Liqperpalabra_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqperpalabra_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqdepprvper_Z( )
   {
      return gxTv_SdtLiquidacion_Liqdepprvper_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqdepprvper_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqdepprvper_Z");
      gxTv_SdtLiquidacion_Liqdepprvper_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqdepprvper_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqdepprvper_Z = "" ;
      SetDirty("Liqdepprvper_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqdepprvper_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqdepprvfec_Z( )
   {
      return gxTv_SdtLiquidacion_Liqdepprvfec_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqdepprvfec_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqdepprvfec_Z");
      gxTv_SdtLiquidacion_Liqdepprvfec_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqdepprvfec_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqdepprvfec_Z = GXutil.nullDate() ;
      SetDirty("Liqdepprvfec_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqdepprvfec_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqdepbandescrip_Z( )
   {
      return gxTv_SdtLiquidacion_Liqdepbandescrip_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqdepbandescrip_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqdepbandescrip_Z");
      gxTv_SdtLiquidacion_Liqdepbandescrip_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqdepbandescrip_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqdepbandescrip_Z = "" ;
      SetDirty("Liqdepbandescrip_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqdepbandescrip_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqdepbancod_Z( )
   {
      return gxTv_SdtLiquidacion_Liqdepbancod_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqdepbancod_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqdepbancod_Z");
      gxTv_SdtLiquidacion_Liqdepbancod_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqdepbancod_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqdepbancod_Z = "" ;
      SetDirty("Liqdepbancod_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqdepbancod_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtLiquidacion_Liqdepperano_Z( )
   {
      return gxTv_SdtLiquidacion_Liqdepperano_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqdepperano_Z( short value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqdepperano_Z");
      gxTv_SdtLiquidacion_Liqdepperano_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqdepperano_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqdepperano_Z = (short)(0) ;
      SetDirty("Liqdepperano_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqdepperano_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacion_Liqdeppermes_Z( )
   {
      return gxTv_SdtLiquidacion_Liqdeppermes_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqdeppermes_Z( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqdeppermes_Z");
      gxTv_SdtLiquidacion_Liqdeppermes_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqdeppermes_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqdeppermes_Z = (byte)(0) ;
      SetDirty("Liqdeppermes_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqdeppermes_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqfecmod_Z( )
   {
      return gxTv_SdtLiquidacion_Liqfecmod_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqfecmod_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqfecmod_Z");
      gxTv_SdtLiquidacion_Liqfecmod_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqfecmod_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqfecmod_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Liqfecmod_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqfecmod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqusumod_Z( )
   {
      return gxTv_SdtLiquidacion_Liqusumod_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqusumod_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqusumod_Z");
      gxTv_SdtLiquidacion_Liqusumod_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqusumod_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqusumod_Z = "" ;
      SetDirty("Liqusumod_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqusumod_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqfecimp_Z( )
   {
      return gxTv_SdtLiquidacion_Liqfecimp_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqfecimp_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqfecimp_Z");
      gxTv_SdtLiquidacion_Liqfecimp_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqfecimp_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqfecimp_Z = GXutil.resetTime( GXutil.nullDate() );
      SetDirty("Liqfecimp_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqfecimp_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacion_Liqpisoganancias_Z( )
   {
      return gxTv_SdtLiquidacion_Liqpisoganancias_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqpisoganancias_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqpisoganancias_Z");
      gxTv_SdtLiquidacion_Liqpisoganancias_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqpisoganancias_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqpisoganancias_Z = DecimalUtil.ZERO ;
      SetDirty("Liqpisoganancias_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqpisoganancias_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacion_Liqpisgansac_Z( )
   {
      return gxTv_SdtLiquidacion_Liqpisgansac_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqpisgansac_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqpisgansac_Z");
      gxTv_SdtLiquidacion_Liqpisgansac_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqpisgansac_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqpisgansac_Z = DecimalUtil.ZERO ;
      SetDirty("Liqpisgansac_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqpisgansac_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacion_Liqtopededinc_Z( )
   {
      return gxTv_SdtLiquidacion_Liqtopededinc_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqtopededinc_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqtopededinc_Z");
      gxTv_SdtLiquidacion_Liqtopededinc_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqtopededinc_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqtopededinc_Z = DecimalUtil.ZERO ;
      SetDirty("Liqtopededinc_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqtopededinc_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqperultnorm_Z( )
   {
      return gxTv_SdtLiquidacion_Liqperultnorm_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqperultnorm_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqperultnorm_Z");
      gxTv_SdtLiquidacion_Liqperultnorm_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqperultnorm_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqperultnorm_Z = GXutil.nullDate() ;
      SetDirty("Liqperultnorm_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqperultnorm_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqerror_Z( )
   {
      return gxTv_SdtLiquidacion_Liqerror_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqerror_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqerror_Z");
      gxTv_SdtLiquidacion_Liqerror_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqerror_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqerror_Z = "" ;
      SetDirty("Liqerror_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqerror_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqerroraux_Z( )
   {
      return gxTv_SdtLiquidacion_Liqerroraux_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqerroraux_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqerroraux_Z");
      gxTv_SdtLiquidacion_Liqerroraux_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqerroraux_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqerroraux_Z = "" ;
      SetDirty("Liqerroraux_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqerroraux_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqnombre_Z( )
   {
      return gxTv_SdtLiquidacion_Liqnombre_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqnombre_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqnombre_Z");
      gxTv_SdtLiquidacion_Liqnombre_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqnombre_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqnombre_Z = "" ;
      SetDirty("Liqnombre_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqnombre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqlegajostxt_Z( )
   {
      return gxTv_SdtLiquidacion_Liqlegajostxt_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqlegajostxt_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqlegajostxt_Z");
      gxTv_SdtLiquidacion_Liqlegajostxt_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqlegajostxt_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqlegajostxt_Z = "" ;
      SetDirty("Liqlegajostxt_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqlegajostxt_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtLiquidacion_Liqsegundos_Z( )
   {
      return gxTv_SdtLiquidacion_Liqsegundos_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqsegundos_Z( java.math.BigDecimal value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqsegundos_Z");
      gxTv_SdtLiquidacion_Liqsegundos_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqsegundos_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqsegundos_Z = DecimalUtil.ZERO ;
      SetDirty("Liqsegundos_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqsegundos_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z( )
   {
      return gxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqrutapdftodosvertical_Z");
      gxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z = "" ;
      SetDirty("Liqrutapdftodosvertical_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z( )
   {
      return gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqrutapdftodoshorizontal_Z");
      gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z = "" ;
      SetDirty("Liqrutapdftodoshorizontal_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z( )
   {
      return gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqrutapdftodosnombrevertical_Z");
      gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z = "" ;
      SetDirty("Liqrutapdftodosnombrevertical_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z( )
   {
      return gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqrutapdftodosnombrehorizontal_Z");
      gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z = "" ;
      SetDirty("Liqrutapdftodosnombrehorizontal_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Periodoliq_Z( )
   {
      return gxTv_SdtLiquidacion_Periodoliq_Z ;
   }

   public void setgxTv_SdtLiquidacion_Periodoliq_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Periodoliq_Z");
      gxTv_SdtLiquidacion_Periodoliq_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Periodoliq_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Periodoliq_Z = GXutil.nullDate() ;
      SetDirty("Periodoliq_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Periodoliq_Z_IsNull( )
   {
      return false ;
   }

   public int getgxTv_SdtLiquidacion_Liqrelnro_Z( )
   {
      return gxTv_SdtLiquidacion_Liqrelnro_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqrelnro_Z( int value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqrelnro_Z");
      gxTv_SdtLiquidacion_Liqrelnro_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqrelnro_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqrelnro_Z = 0 ;
      SetDirty("Liqrelnro_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqrelnro_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLiquidacion_Liqsac_Z( )
   {
      return gxTv_SdtLiquidacion_Liqsac_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqsac_Z( boolean value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqsac_Z");
      gxTv_SdtLiquidacion_Liqsac_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqsac_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqsac_Z = false ;
      SetDirty("Liqsac_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqsac_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqsaclog_Z( )
   {
      return gxTv_SdtLiquidacion_Liqsaclog_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqsaclog_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqsaclog_Z");
      gxTv_SdtLiquidacion_Liqsaclog_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqsaclog_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqsaclog_Z = "" ;
      SetDirty("Liqsaclog_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqsaclog_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtLiquidacion_Liqcancel_Z( )
   {
      return gxTv_SdtLiquidacion_Liqcancel_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqcancel_Z( boolean value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqcancel_Z");
      gxTv_SdtLiquidacion_Liqcancel_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqcancel_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqcancel_Z = false ;
      SetDirty("Liqcancel_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqcancel_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqmodtra_Z( )
   {
      return gxTv_SdtLiquidacion_Liqmodtra_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqmodtra_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqmodtra_Z");
      gxTv_SdtLiquidacion_Liqmodtra_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqmodtra_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqmodtra_Z = "" ;
      SetDirty("Liqmodtra_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqmodtra_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacion_Liqfrecpag_Z( )
   {
      return gxTv_SdtLiquidacion_Liqfrecpag_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqfrecpag_Z( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqfrecpag_Z");
      gxTv_SdtLiquidacion_Liqfrecpag_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqfrecpag_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqfrecpag_Z = (byte)(0) ;
      SetDirty("Liqfrecpag_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqfrecpag_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqperdes_Z( )
   {
      return gxTv_SdtLiquidacion_Liqperdes_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqperdes_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqperdes_Z");
      gxTv_SdtLiquidacion_Liqperdes_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqperdes_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqperdes_Z = GXutil.nullDate() ;
      SetDirty("Liqperdes_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqperdes_Z_IsNull( )
   {
      return false ;
   }

   public java.util.Date getgxTv_SdtLiquidacion_Liqperhas_Z( )
   {
      return gxTv_SdtLiquidacion_Liqperhas_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqperhas_Z( java.util.Date value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqperhas_Z");
      gxTv_SdtLiquidacion_Liqperhas_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqperhas_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqperhas_Z = GXutil.nullDate() ;
      SetDirty("Liqperhas_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqperhas_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtLiquidacion_Liqtipotarifa_Z( )
   {
      return gxTv_SdtLiquidacion_Liqtipotarifa_Z ;
   }

   public void setgxTv_SdtLiquidacion_Liqtipotarifa_Z( String value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqtipotarifa_Z");
      gxTv_SdtLiquidacion_Liqtipotarifa_Z = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqtipotarifa_Z_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqtipotarifa_Z = "" ;
      SetDirty("Liqtipotarifa_Z");
   }

   public boolean getgxTv_SdtLiquidacion_Liqtipotarifa_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacion_Tliqcod_N( )
   {
      return gxTv_SdtLiquidacion_Tliqcod_N ;
   }

   public void setgxTv_SdtLiquidacion_Tliqcod_N( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Tliqcod_N");
      gxTv_SdtLiquidacion_Tliqcod_N = value ;
   }

   public void setgxTv_SdtLiquidacion_Tliqcod_N_SetNull( )
   {
      gxTv_SdtLiquidacion_Tliqcod_N = (byte)(0) ;
      SetDirty("Tliqcod_N");
   }

   public boolean getgxTv_SdtLiquidacion_Tliqcod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacion_Liqclase_N( )
   {
      return gxTv_SdtLiquidacion_Liqclase_N ;
   }

   public void setgxTv_SdtLiquidacion_Liqclase_N( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqclase_N");
      gxTv_SdtLiquidacion_Liqclase_N = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqclase_N_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqclase_N = (byte)(0) ;
      SetDirty("Liqclase_N");
   }

   public boolean getgxTv_SdtLiquidacion_Liqclase_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacion_Liqpdfestado_N( )
   {
      return gxTv_SdtLiquidacion_Liqpdfestado_N ;
   }

   public void setgxTv_SdtLiquidacion_Liqpdfestado_N( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqpdfestado_N");
      gxTv_SdtLiquidacion_Liqpdfestado_N = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqpdfestado_N_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqpdfestado_N = (byte)(0) ;
      SetDirty("Liqpdfestado_N");
   }

   public boolean getgxTv_SdtLiquidacion_Liqpdfestado_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacion_Liqdepbancod_N( )
   {
      return gxTv_SdtLiquidacion_Liqdepbancod_N ;
   }

   public void setgxTv_SdtLiquidacion_Liqdepbancod_N( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqdepbancod_N");
      gxTv_SdtLiquidacion_Liqdepbancod_N = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqdepbancod_N_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqdepbancod_N = (byte)(0) ;
      SetDirty("Liqdepbancod_N");
   }

   public boolean getgxTv_SdtLiquidacion_Liqdepbancod_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacion_Liqrelnro_N( )
   {
      return gxTv_SdtLiquidacion_Liqrelnro_N ;
   }

   public void setgxTv_SdtLiquidacion_Liqrelnro_N( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqrelnro_N");
      gxTv_SdtLiquidacion_Liqrelnro_N = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqrelnro_N_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqrelnro_N = (byte)(0) ;
      SetDirty("Liqrelnro_N");
   }

   public boolean getgxTv_SdtLiquidacion_Liqrelnro_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacion_Liqsac_N( )
   {
      return gxTv_SdtLiquidacion_Liqsac_N ;
   }

   public void setgxTv_SdtLiquidacion_Liqsac_N( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqsac_N");
      gxTv_SdtLiquidacion_Liqsac_N = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqsac_N_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqsac_N = (byte)(0) ;
      SetDirty("Liqsac_N");
   }

   public boolean getgxTv_SdtLiquidacion_Liqsac_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtLiquidacion_Liqsaclog_N( )
   {
      return gxTv_SdtLiquidacion_Liqsaclog_N ;
   }

   public void setgxTv_SdtLiquidacion_Liqsaclog_N( byte value )
   {
      gxTv_SdtLiquidacion_N = (byte)(0) ;
      SetDirty("Liqsaclog_N");
      gxTv_SdtLiquidacion_Liqsaclog_N = value ;
   }

   public void setgxTv_SdtLiquidacion_Liqsaclog_N_SetNull( )
   {
      gxTv_SdtLiquidacion_Liqsaclog_N = (byte)(0) ;
      SetDirty("Liqsaclog_N");
   }

   public boolean getgxTv_SdtLiquidacion_Liqsaclog_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      web.liquidacion_bc obj;
      obj = new web.liquidacion_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtLiquidacion_N = (byte)(1) ;
      gxTv_SdtLiquidacion_Empnom = "" ;
      gxTv_SdtLiquidacion_Liqdescrip = "" ;
      gxTv_SdtLiquidacion_Liqfecha = GXutil.nullDate() ;
      gxTv_SdtLiquidacion_Liqperiodo = GXutil.nullDate() ;
      gxTv_SdtLiquidacion_Liqfecpago = GXutil.nullDate() ;
      gxTv_SdtLiquidacion_Tliqcod = "" ;
      gxTv_SdtLiquidacion_Tliqdesc = "" ;
      gxTv_SdtLiquidacion_Tliqdescaux = "" ;
      gxTv_SdtLiquidacion_Liqpdfestado = "" ;
      gxTv_SdtLiquidacion_Liqimpneto = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacion_Liqimpdescuentos = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacion_Liqimpretengan = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacion_Liqimpbruto = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacion_Liqfeccre = GXutil.nullDate() ;
      gxTv_SdtLiquidacion_Liqusucre = "" ;
      gxTv_SdtLiquidacion_Liqpersindia = "" ;
      gxTv_SdtLiquidacion_Liqperpalabra = "" ;
      gxTv_SdtLiquidacion_Liqdepprvper = "" ;
      gxTv_SdtLiquidacion_Liqdepprvfec = GXutil.nullDate() ;
      gxTv_SdtLiquidacion_Liqdepbandescrip = "" ;
      gxTv_SdtLiquidacion_Liqdepbancod = "" ;
      gxTv_SdtLiquidacion_Liqfecmod = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtLiquidacion_Liqusumod = "" ;
      gxTv_SdtLiquidacion_Liqfecimp = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtLiquidacion_Liqpisoganancias = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacion_Liqpisgansac = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacion_Liqtopededinc = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacion_Liqperultnorm = GXutil.nullDate() ;
      gxTv_SdtLiquidacion_Liqerror = "" ;
      gxTv_SdtLiquidacion_Liqerroraux = "" ;
      gxTv_SdtLiquidacion_Liqnombre = "" ;
      gxTv_SdtLiquidacion_Liqlegajostxt = "" ;
      gxTv_SdtLiquidacion_Liqsegundos = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacion_Liqrutapdftodosvertical = "" ;
      gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal = "" ;
      gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical = "" ;
      gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal = "" ;
      gxTv_SdtLiquidacion_Liqlog = "" ;
      gxTv_SdtLiquidacion_Periodoliq = GXutil.nullDate() ;
      gxTv_SdtLiquidacion_Liqsaclog = "" ;
      gxTv_SdtLiquidacion_Liqmodtra = "" ;
      gxTv_SdtLiquidacion_Liqperdes = GXutil.nullDate() ;
      gxTv_SdtLiquidacion_Liqperhas = GXutil.nullDate() ;
      gxTv_SdtLiquidacion_Liqtipotarifa = "" ;
      gxTv_SdtLiquidacion_Mode = "" ;
      gxTv_SdtLiquidacion_Empnom_Z = "" ;
      gxTv_SdtLiquidacion_Liqdescrip_Z = "" ;
      gxTv_SdtLiquidacion_Liqfecha_Z = GXutil.nullDate() ;
      gxTv_SdtLiquidacion_Liqperiodo_Z = GXutil.nullDate() ;
      gxTv_SdtLiquidacion_Liqfecpago_Z = GXutil.nullDate() ;
      gxTv_SdtLiquidacion_Tliqcod_Z = "" ;
      gxTv_SdtLiquidacion_Tliqdesc_Z = "" ;
      gxTv_SdtLiquidacion_Tliqdescaux_Z = "" ;
      gxTv_SdtLiquidacion_Liqpdfestado_Z = "" ;
      gxTv_SdtLiquidacion_Liqimpneto_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacion_Liqimpdescuentos_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacion_Liqimpretengan_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacion_Liqimpbruto_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacion_Liqfeccre_Z = GXutil.nullDate() ;
      gxTv_SdtLiquidacion_Liqusucre_Z = "" ;
      gxTv_SdtLiquidacion_Liqpersindia_Z = "" ;
      gxTv_SdtLiquidacion_Liqperpalabra_Z = "" ;
      gxTv_SdtLiquidacion_Liqdepprvper_Z = "" ;
      gxTv_SdtLiquidacion_Liqdepprvfec_Z = GXutil.nullDate() ;
      gxTv_SdtLiquidacion_Liqdepbandescrip_Z = "" ;
      gxTv_SdtLiquidacion_Liqdepbancod_Z = "" ;
      gxTv_SdtLiquidacion_Liqfecmod_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtLiquidacion_Liqusumod_Z = "" ;
      gxTv_SdtLiquidacion_Liqfecimp_Z = GXutil.resetTime( GXutil.nullDate() );
      gxTv_SdtLiquidacion_Liqpisoganancias_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacion_Liqpisgansac_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacion_Liqtopededinc_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacion_Liqperultnorm_Z = GXutil.nullDate() ;
      gxTv_SdtLiquidacion_Liqerror_Z = "" ;
      gxTv_SdtLiquidacion_Liqerroraux_Z = "" ;
      gxTv_SdtLiquidacion_Liqnombre_Z = "" ;
      gxTv_SdtLiquidacion_Liqlegajostxt_Z = "" ;
      gxTv_SdtLiquidacion_Liqsegundos_Z = DecimalUtil.ZERO ;
      gxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z = "" ;
      gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z = "" ;
      gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z = "" ;
      gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z = "" ;
      gxTv_SdtLiquidacion_Periodoliq_Z = GXutil.nullDate() ;
      gxTv_SdtLiquidacion_Liqsaclog_Z = "" ;
      gxTv_SdtLiquidacion_Liqmodtra_Z = "" ;
      gxTv_SdtLiquidacion_Liqperdes_Z = GXutil.nullDate() ;
      gxTv_SdtLiquidacion_Liqperhas_Z = GXutil.nullDate() ;
      gxTv_SdtLiquidacion_Liqtipotarifa_Z = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_SdtLiquidacion_N ;
   }

   public web.SdtLiquidacion Clone( )
   {
      web.SdtLiquidacion sdt;
      web.liquidacion_bc obj;
      sdt = (web.SdtLiquidacion)(clone()) ;
      obj = (web.liquidacion_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( web.StructSdtLiquidacion struct )
   {
      setgxTv_SdtLiquidacion_Clicod(struct.getClicod());
      setgxTv_SdtLiquidacion_Empcod(struct.getEmpcod());
      setgxTv_SdtLiquidacion_Empnom(struct.getEmpnom());
      setgxTv_SdtLiquidacion_Liqnro(struct.getLiqnro());
      setgxTv_SdtLiquidacion_Liqdescrip(struct.getLiqdescrip());
      setgxTv_SdtLiquidacion_Liqfecha(struct.getLiqfecha());
      setgxTv_SdtLiquidacion_Liqperano(struct.getLiqperano());
      setgxTv_SdtLiquidacion_Liqpermes(struct.getLiqpermes());
      setgxTv_SdtLiquidacion_Liqperiodo(struct.getLiqperiodo());
      setgxTv_SdtLiquidacion_Liqfecpago(struct.getLiqfecpago());
      setgxTv_SdtLiquidacion_Tliqcod(struct.getTliqcod());
      setgxTv_SdtLiquidacion_Tliqdesc(struct.getTliqdesc());
      setgxTv_SdtLiquidacion_Tliqdescaux(struct.getTliqdescaux());
      setgxTv_SdtLiquidacion_Liqestado(struct.getLiqestado());
      setgxTv_SdtLiquidacion_Liqlsddepest(struct.getLiqlsddepest());
      setgxTv_SdtLiquidacion_Liqauxestado(struct.getLiqauxestado());
      setgxTv_SdtLiquidacion_Liqcontrest(struct.getLiqcontrest());
      setgxTv_SdtLiquidacion_Liqclase(struct.getLiqclase());
      setgxTv_SdtLiquidacion_Liqpdfestado(struct.getLiqpdfestado());
      setgxTv_SdtLiquidacion_Liqgeninter(struct.getLiqgeninter());
      setgxTv_SdtLiquidacion_Liqcontabilizada(struct.getLiqcontabilizada());
      setgxTv_SdtLiquidacion_Liqcntleg(struct.getLiqcntleg());
      setgxTv_SdtLiquidacion_Liqimpneto(struct.getLiqimpneto());
      setgxTv_SdtLiquidacion_Liqimpdescuentos(struct.getLiqimpdescuentos());
      setgxTv_SdtLiquidacion_Liqimpretengan(struct.getLiqimpretengan());
      setgxTv_SdtLiquidacion_Liqimpbruto(struct.getLiqimpbruto());
      setgxTv_SdtLiquidacion_Legespecificos(struct.getLegespecificos());
      setgxTv_SdtLiquidacion_Liqfeccre(struct.getLiqfeccre());
      setgxTv_SdtLiquidacion_Liqusucre(struct.getLiqusucre());
      setgxTv_SdtLiquidacion_Liqpersindia(struct.getLiqpersindia());
      setgxTv_SdtLiquidacion_Liqperpalabra(struct.getLiqperpalabra());
      setgxTv_SdtLiquidacion_Liqdepprvper(struct.getLiqdepprvper());
      setgxTv_SdtLiquidacion_Liqdepprvfec(struct.getLiqdepprvfec());
      setgxTv_SdtLiquidacion_Liqdepbandescrip(struct.getLiqdepbandescrip());
      setgxTv_SdtLiquidacion_Liqdepbancod(struct.getLiqdepbancod());
      setgxTv_SdtLiquidacion_Liqdepperano(struct.getLiqdepperano());
      setgxTv_SdtLiquidacion_Liqdeppermes(struct.getLiqdeppermes());
      setgxTv_SdtLiquidacion_Liqfecmod(struct.getLiqfecmod());
      setgxTv_SdtLiquidacion_Liqusumod(struct.getLiqusumod());
      setgxTv_SdtLiquidacion_Liqfecimp(struct.getLiqfecimp());
      setgxTv_SdtLiquidacion_Liqpisoganancias(struct.getLiqpisoganancias());
      setgxTv_SdtLiquidacion_Liqpisgansac(struct.getLiqpisgansac());
      setgxTv_SdtLiquidacion_Liqtopededinc(struct.getLiqtopededinc());
      setgxTv_SdtLiquidacion_Liqperultnorm(struct.getLiqperultnorm());
      setgxTv_SdtLiquidacion_Liqerror(struct.getLiqerror());
      setgxTv_SdtLiquidacion_Liqerroraux(struct.getLiqerroraux());
      setgxTv_SdtLiquidacion_Liqnombre(struct.getLiqnombre());
      setgxTv_SdtLiquidacion_Liqlegajostxt(struct.getLiqlegajostxt());
      setgxTv_SdtLiquidacion_Liqsegundos(struct.getLiqsegundos());
      setgxTv_SdtLiquidacion_Liqrutapdftodosvertical(struct.getLiqrutapdftodosvertical());
      setgxTv_SdtLiquidacion_Liqrutapdftodoshorizontal(struct.getLiqrutapdftodoshorizontal());
      setgxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical(struct.getLiqrutapdftodosnombrevertical());
      setgxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal(struct.getLiqrutapdftodosnombrehorizontal());
      setgxTv_SdtLiquidacion_Liqlog(struct.getLiqlog());
      setgxTv_SdtLiquidacion_Periodoliq(struct.getPeriodoliq());
      setgxTv_SdtLiquidacion_Liqrelnro(struct.getLiqrelnro());
      setgxTv_SdtLiquidacion_Liqsac(struct.getLiqsac());
      setgxTv_SdtLiquidacion_Liqsaclog(struct.getLiqsaclog());
      setgxTv_SdtLiquidacion_Liqcancel(struct.getLiqcancel());
      setgxTv_SdtLiquidacion_Liqmodtra(struct.getLiqmodtra());
      setgxTv_SdtLiquidacion_Liqfrecpag(struct.getLiqfrecpag());
      setgxTv_SdtLiquidacion_Liqperdes(struct.getLiqperdes());
      setgxTv_SdtLiquidacion_Liqperhas(struct.getLiqperhas());
      setgxTv_SdtLiquidacion_Liqtipotarifa(struct.getLiqtipotarifa());
      setgxTv_SdtLiquidacion_Mode(struct.getMode());
      setgxTv_SdtLiquidacion_Initialized(struct.getInitialized());
      setgxTv_SdtLiquidacion_Clicod_Z(struct.getClicod_Z());
      setgxTv_SdtLiquidacion_Empcod_Z(struct.getEmpcod_Z());
      setgxTv_SdtLiquidacion_Empnom_Z(struct.getEmpnom_Z());
      setgxTv_SdtLiquidacion_Liqnro_Z(struct.getLiqnro_Z());
      setgxTv_SdtLiquidacion_Liqdescrip_Z(struct.getLiqdescrip_Z());
      setgxTv_SdtLiquidacion_Liqfecha_Z(struct.getLiqfecha_Z());
      setgxTv_SdtLiquidacion_Liqperano_Z(struct.getLiqperano_Z());
      setgxTv_SdtLiquidacion_Liqpermes_Z(struct.getLiqpermes_Z());
      setgxTv_SdtLiquidacion_Liqperiodo_Z(struct.getLiqperiodo_Z());
      setgxTv_SdtLiquidacion_Liqfecpago_Z(struct.getLiqfecpago_Z());
      setgxTv_SdtLiquidacion_Tliqcod_Z(struct.getTliqcod_Z());
      setgxTv_SdtLiquidacion_Tliqdesc_Z(struct.getTliqdesc_Z());
      setgxTv_SdtLiquidacion_Tliqdescaux_Z(struct.getTliqdescaux_Z());
      setgxTv_SdtLiquidacion_Liqestado_Z(struct.getLiqestado_Z());
      setgxTv_SdtLiquidacion_Liqlsddepest_Z(struct.getLiqlsddepest_Z());
      setgxTv_SdtLiquidacion_Liqauxestado_Z(struct.getLiqauxestado_Z());
      setgxTv_SdtLiquidacion_Liqcontrest_Z(struct.getLiqcontrest_Z());
      setgxTv_SdtLiquidacion_Liqclase_Z(struct.getLiqclase_Z());
      setgxTv_SdtLiquidacion_Liqpdfestado_Z(struct.getLiqpdfestado_Z());
      setgxTv_SdtLiquidacion_Liqgeninter_Z(struct.getLiqgeninter_Z());
      setgxTv_SdtLiquidacion_Liqcontabilizada_Z(struct.getLiqcontabilizada_Z());
      setgxTv_SdtLiquidacion_Liqcntleg_Z(struct.getLiqcntleg_Z());
      setgxTv_SdtLiquidacion_Liqimpneto_Z(struct.getLiqimpneto_Z());
      setgxTv_SdtLiquidacion_Liqimpdescuentos_Z(struct.getLiqimpdescuentos_Z());
      setgxTv_SdtLiquidacion_Liqimpretengan_Z(struct.getLiqimpretengan_Z());
      setgxTv_SdtLiquidacion_Liqimpbruto_Z(struct.getLiqimpbruto_Z());
      setgxTv_SdtLiquidacion_Legespecificos_Z(struct.getLegespecificos_Z());
      setgxTv_SdtLiquidacion_Liqfeccre_Z(struct.getLiqfeccre_Z());
      setgxTv_SdtLiquidacion_Liqusucre_Z(struct.getLiqusucre_Z());
      setgxTv_SdtLiquidacion_Liqpersindia_Z(struct.getLiqpersindia_Z());
      setgxTv_SdtLiquidacion_Liqperpalabra_Z(struct.getLiqperpalabra_Z());
      setgxTv_SdtLiquidacion_Liqdepprvper_Z(struct.getLiqdepprvper_Z());
      setgxTv_SdtLiquidacion_Liqdepprvfec_Z(struct.getLiqdepprvfec_Z());
      setgxTv_SdtLiquidacion_Liqdepbandescrip_Z(struct.getLiqdepbandescrip_Z());
      setgxTv_SdtLiquidacion_Liqdepbancod_Z(struct.getLiqdepbancod_Z());
      setgxTv_SdtLiquidacion_Liqdepperano_Z(struct.getLiqdepperano_Z());
      setgxTv_SdtLiquidacion_Liqdeppermes_Z(struct.getLiqdeppermes_Z());
      setgxTv_SdtLiquidacion_Liqfecmod_Z(struct.getLiqfecmod_Z());
      setgxTv_SdtLiquidacion_Liqusumod_Z(struct.getLiqusumod_Z());
      setgxTv_SdtLiquidacion_Liqfecimp_Z(struct.getLiqfecimp_Z());
      setgxTv_SdtLiquidacion_Liqpisoganancias_Z(struct.getLiqpisoganancias_Z());
      setgxTv_SdtLiquidacion_Liqpisgansac_Z(struct.getLiqpisgansac_Z());
      setgxTv_SdtLiquidacion_Liqtopededinc_Z(struct.getLiqtopededinc_Z());
      setgxTv_SdtLiquidacion_Liqperultnorm_Z(struct.getLiqperultnorm_Z());
      setgxTv_SdtLiquidacion_Liqerror_Z(struct.getLiqerror_Z());
      setgxTv_SdtLiquidacion_Liqerroraux_Z(struct.getLiqerroraux_Z());
      setgxTv_SdtLiquidacion_Liqnombre_Z(struct.getLiqnombre_Z());
      setgxTv_SdtLiquidacion_Liqlegajostxt_Z(struct.getLiqlegajostxt_Z());
      setgxTv_SdtLiquidacion_Liqsegundos_Z(struct.getLiqsegundos_Z());
      setgxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z(struct.getLiqrutapdftodosvertical_Z());
      setgxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z(struct.getLiqrutapdftodoshorizontal_Z());
      setgxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z(struct.getLiqrutapdftodosnombrevertical_Z());
      setgxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z(struct.getLiqrutapdftodosnombrehorizontal_Z());
      setgxTv_SdtLiquidacion_Periodoliq_Z(struct.getPeriodoliq_Z());
      setgxTv_SdtLiquidacion_Liqrelnro_Z(struct.getLiqrelnro_Z());
      setgxTv_SdtLiquidacion_Liqsac_Z(struct.getLiqsac_Z());
      setgxTv_SdtLiquidacion_Liqsaclog_Z(struct.getLiqsaclog_Z());
      setgxTv_SdtLiquidacion_Liqcancel_Z(struct.getLiqcancel_Z());
      setgxTv_SdtLiquidacion_Liqmodtra_Z(struct.getLiqmodtra_Z());
      setgxTv_SdtLiquidacion_Liqfrecpag_Z(struct.getLiqfrecpag_Z());
      setgxTv_SdtLiquidacion_Liqperdes_Z(struct.getLiqperdes_Z());
      setgxTv_SdtLiquidacion_Liqperhas_Z(struct.getLiqperhas_Z());
      setgxTv_SdtLiquidacion_Liqtipotarifa_Z(struct.getLiqtipotarifa_Z());
      setgxTv_SdtLiquidacion_Tliqcod_N(struct.getTliqcod_N());
      setgxTv_SdtLiquidacion_Liqclase_N(struct.getLiqclase_N());
      setgxTv_SdtLiquidacion_Liqpdfestado_N(struct.getLiqpdfestado_N());
      setgxTv_SdtLiquidacion_Liqdepbancod_N(struct.getLiqdepbancod_N());
      setgxTv_SdtLiquidacion_Liqrelnro_N(struct.getLiqrelnro_N());
      setgxTv_SdtLiquidacion_Liqsac_N(struct.getLiqsac_N());
      setgxTv_SdtLiquidacion_Liqsaclog_N(struct.getLiqsaclog_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtLiquidacion getStruct( )
   {
      web.StructSdtLiquidacion struct = new web.StructSdtLiquidacion ();
      struct.setClicod(getgxTv_SdtLiquidacion_Clicod());
      struct.setEmpcod(getgxTv_SdtLiquidacion_Empcod());
      struct.setEmpnom(getgxTv_SdtLiquidacion_Empnom());
      struct.setLiqnro(getgxTv_SdtLiquidacion_Liqnro());
      struct.setLiqdescrip(getgxTv_SdtLiquidacion_Liqdescrip());
      struct.setLiqfecha(getgxTv_SdtLiquidacion_Liqfecha());
      struct.setLiqperano(getgxTv_SdtLiquidacion_Liqperano());
      struct.setLiqpermes(getgxTv_SdtLiquidacion_Liqpermes());
      struct.setLiqperiodo(getgxTv_SdtLiquidacion_Liqperiodo());
      struct.setLiqfecpago(getgxTv_SdtLiquidacion_Liqfecpago());
      struct.setTliqcod(getgxTv_SdtLiquidacion_Tliqcod());
      struct.setTliqdesc(getgxTv_SdtLiquidacion_Tliqdesc());
      struct.setTliqdescaux(getgxTv_SdtLiquidacion_Tliqdescaux());
      struct.setLiqestado(getgxTv_SdtLiquidacion_Liqestado());
      struct.setLiqlsddepest(getgxTv_SdtLiquidacion_Liqlsddepest());
      struct.setLiqauxestado(getgxTv_SdtLiquidacion_Liqauxestado());
      struct.setLiqcontrest(getgxTv_SdtLiquidacion_Liqcontrest());
      struct.setLiqclase(getgxTv_SdtLiquidacion_Liqclase());
      struct.setLiqpdfestado(getgxTv_SdtLiquidacion_Liqpdfestado());
      struct.setLiqgeninter(getgxTv_SdtLiquidacion_Liqgeninter());
      struct.setLiqcontabilizada(getgxTv_SdtLiquidacion_Liqcontabilizada());
      struct.setLiqcntleg(getgxTv_SdtLiquidacion_Liqcntleg());
      struct.setLiqimpneto(getgxTv_SdtLiquidacion_Liqimpneto());
      struct.setLiqimpdescuentos(getgxTv_SdtLiquidacion_Liqimpdescuentos());
      struct.setLiqimpretengan(getgxTv_SdtLiquidacion_Liqimpretengan());
      struct.setLiqimpbruto(getgxTv_SdtLiquidacion_Liqimpbruto());
      struct.setLegespecificos(getgxTv_SdtLiquidacion_Legespecificos());
      struct.setLiqfeccre(getgxTv_SdtLiquidacion_Liqfeccre());
      struct.setLiqusucre(getgxTv_SdtLiquidacion_Liqusucre());
      struct.setLiqpersindia(getgxTv_SdtLiquidacion_Liqpersindia());
      struct.setLiqperpalabra(getgxTv_SdtLiquidacion_Liqperpalabra());
      struct.setLiqdepprvper(getgxTv_SdtLiquidacion_Liqdepprvper());
      struct.setLiqdepprvfec(getgxTv_SdtLiquidacion_Liqdepprvfec());
      struct.setLiqdepbandescrip(getgxTv_SdtLiquidacion_Liqdepbandescrip());
      struct.setLiqdepbancod(getgxTv_SdtLiquidacion_Liqdepbancod());
      struct.setLiqdepperano(getgxTv_SdtLiquidacion_Liqdepperano());
      struct.setLiqdeppermes(getgxTv_SdtLiquidacion_Liqdeppermes());
      struct.setLiqfecmod(getgxTv_SdtLiquidacion_Liqfecmod());
      struct.setLiqusumod(getgxTv_SdtLiquidacion_Liqusumod());
      struct.setLiqfecimp(getgxTv_SdtLiquidacion_Liqfecimp());
      struct.setLiqpisoganancias(getgxTv_SdtLiquidacion_Liqpisoganancias());
      struct.setLiqpisgansac(getgxTv_SdtLiquidacion_Liqpisgansac());
      struct.setLiqtopededinc(getgxTv_SdtLiquidacion_Liqtopededinc());
      struct.setLiqperultnorm(getgxTv_SdtLiquidacion_Liqperultnorm());
      struct.setLiqerror(getgxTv_SdtLiquidacion_Liqerror());
      struct.setLiqerroraux(getgxTv_SdtLiquidacion_Liqerroraux());
      struct.setLiqnombre(getgxTv_SdtLiquidacion_Liqnombre());
      struct.setLiqlegajostxt(getgxTv_SdtLiquidacion_Liqlegajostxt());
      struct.setLiqsegundos(getgxTv_SdtLiquidacion_Liqsegundos());
      struct.setLiqrutapdftodosvertical(getgxTv_SdtLiquidacion_Liqrutapdftodosvertical());
      struct.setLiqrutapdftodoshorizontal(getgxTv_SdtLiquidacion_Liqrutapdftodoshorizontal());
      struct.setLiqrutapdftodosnombrevertical(getgxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical());
      struct.setLiqrutapdftodosnombrehorizontal(getgxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal());
      struct.setLiqlog(getgxTv_SdtLiquidacion_Liqlog());
      struct.setPeriodoliq(getgxTv_SdtLiquidacion_Periodoliq());
      struct.setLiqrelnro(getgxTv_SdtLiquidacion_Liqrelnro());
      struct.setLiqsac(getgxTv_SdtLiquidacion_Liqsac());
      struct.setLiqsaclog(getgxTv_SdtLiquidacion_Liqsaclog());
      struct.setLiqcancel(getgxTv_SdtLiquidacion_Liqcancel());
      struct.setLiqmodtra(getgxTv_SdtLiquidacion_Liqmodtra());
      struct.setLiqfrecpag(getgxTv_SdtLiquidacion_Liqfrecpag());
      struct.setLiqperdes(getgxTv_SdtLiquidacion_Liqperdes());
      struct.setLiqperhas(getgxTv_SdtLiquidacion_Liqperhas());
      struct.setLiqtipotarifa(getgxTv_SdtLiquidacion_Liqtipotarifa());
      struct.setMode(getgxTv_SdtLiquidacion_Mode());
      struct.setInitialized(getgxTv_SdtLiquidacion_Initialized());
      struct.setClicod_Z(getgxTv_SdtLiquidacion_Clicod_Z());
      struct.setEmpcod_Z(getgxTv_SdtLiquidacion_Empcod_Z());
      struct.setEmpnom_Z(getgxTv_SdtLiquidacion_Empnom_Z());
      struct.setLiqnro_Z(getgxTv_SdtLiquidacion_Liqnro_Z());
      struct.setLiqdescrip_Z(getgxTv_SdtLiquidacion_Liqdescrip_Z());
      struct.setLiqfecha_Z(getgxTv_SdtLiquidacion_Liqfecha_Z());
      struct.setLiqperano_Z(getgxTv_SdtLiquidacion_Liqperano_Z());
      struct.setLiqpermes_Z(getgxTv_SdtLiquidacion_Liqpermes_Z());
      struct.setLiqperiodo_Z(getgxTv_SdtLiquidacion_Liqperiodo_Z());
      struct.setLiqfecpago_Z(getgxTv_SdtLiquidacion_Liqfecpago_Z());
      struct.setTliqcod_Z(getgxTv_SdtLiquidacion_Tliqcod_Z());
      struct.setTliqdesc_Z(getgxTv_SdtLiquidacion_Tliqdesc_Z());
      struct.setTliqdescaux_Z(getgxTv_SdtLiquidacion_Tliqdescaux_Z());
      struct.setLiqestado_Z(getgxTv_SdtLiquidacion_Liqestado_Z());
      struct.setLiqlsddepest_Z(getgxTv_SdtLiquidacion_Liqlsddepest_Z());
      struct.setLiqauxestado_Z(getgxTv_SdtLiquidacion_Liqauxestado_Z());
      struct.setLiqcontrest_Z(getgxTv_SdtLiquidacion_Liqcontrest_Z());
      struct.setLiqclase_Z(getgxTv_SdtLiquidacion_Liqclase_Z());
      struct.setLiqpdfestado_Z(getgxTv_SdtLiquidacion_Liqpdfestado_Z());
      struct.setLiqgeninter_Z(getgxTv_SdtLiquidacion_Liqgeninter_Z());
      struct.setLiqcontabilizada_Z(getgxTv_SdtLiquidacion_Liqcontabilizada_Z());
      struct.setLiqcntleg_Z(getgxTv_SdtLiquidacion_Liqcntleg_Z());
      struct.setLiqimpneto_Z(getgxTv_SdtLiquidacion_Liqimpneto_Z());
      struct.setLiqimpdescuentos_Z(getgxTv_SdtLiquidacion_Liqimpdescuentos_Z());
      struct.setLiqimpretengan_Z(getgxTv_SdtLiquidacion_Liqimpretengan_Z());
      struct.setLiqimpbruto_Z(getgxTv_SdtLiquidacion_Liqimpbruto_Z());
      struct.setLegespecificos_Z(getgxTv_SdtLiquidacion_Legespecificos_Z());
      struct.setLiqfeccre_Z(getgxTv_SdtLiquidacion_Liqfeccre_Z());
      struct.setLiqusucre_Z(getgxTv_SdtLiquidacion_Liqusucre_Z());
      struct.setLiqpersindia_Z(getgxTv_SdtLiquidacion_Liqpersindia_Z());
      struct.setLiqperpalabra_Z(getgxTv_SdtLiquidacion_Liqperpalabra_Z());
      struct.setLiqdepprvper_Z(getgxTv_SdtLiquidacion_Liqdepprvper_Z());
      struct.setLiqdepprvfec_Z(getgxTv_SdtLiquidacion_Liqdepprvfec_Z());
      struct.setLiqdepbandescrip_Z(getgxTv_SdtLiquidacion_Liqdepbandescrip_Z());
      struct.setLiqdepbancod_Z(getgxTv_SdtLiquidacion_Liqdepbancod_Z());
      struct.setLiqdepperano_Z(getgxTv_SdtLiquidacion_Liqdepperano_Z());
      struct.setLiqdeppermes_Z(getgxTv_SdtLiquidacion_Liqdeppermes_Z());
      struct.setLiqfecmod_Z(getgxTv_SdtLiquidacion_Liqfecmod_Z());
      struct.setLiqusumod_Z(getgxTv_SdtLiquidacion_Liqusumod_Z());
      struct.setLiqfecimp_Z(getgxTv_SdtLiquidacion_Liqfecimp_Z());
      struct.setLiqpisoganancias_Z(getgxTv_SdtLiquidacion_Liqpisoganancias_Z());
      struct.setLiqpisgansac_Z(getgxTv_SdtLiquidacion_Liqpisgansac_Z());
      struct.setLiqtopededinc_Z(getgxTv_SdtLiquidacion_Liqtopededinc_Z());
      struct.setLiqperultnorm_Z(getgxTv_SdtLiquidacion_Liqperultnorm_Z());
      struct.setLiqerror_Z(getgxTv_SdtLiquidacion_Liqerror_Z());
      struct.setLiqerroraux_Z(getgxTv_SdtLiquidacion_Liqerroraux_Z());
      struct.setLiqnombre_Z(getgxTv_SdtLiquidacion_Liqnombre_Z());
      struct.setLiqlegajostxt_Z(getgxTv_SdtLiquidacion_Liqlegajostxt_Z());
      struct.setLiqsegundos_Z(getgxTv_SdtLiquidacion_Liqsegundos_Z());
      struct.setLiqrutapdftodosvertical_Z(getgxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z());
      struct.setLiqrutapdftodoshorizontal_Z(getgxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z());
      struct.setLiqrutapdftodosnombrevertical_Z(getgxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z());
      struct.setLiqrutapdftodosnombrehorizontal_Z(getgxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z());
      struct.setPeriodoliq_Z(getgxTv_SdtLiquidacion_Periodoliq_Z());
      struct.setLiqrelnro_Z(getgxTv_SdtLiquidacion_Liqrelnro_Z());
      struct.setLiqsac_Z(getgxTv_SdtLiquidacion_Liqsac_Z());
      struct.setLiqsaclog_Z(getgxTv_SdtLiquidacion_Liqsaclog_Z());
      struct.setLiqcancel_Z(getgxTv_SdtLiquidacion_Liqcancel_Z());
      struct.setLiqmodtra_Z(getgxTv_SdtLiquidacion_Liqmodtra_Z());
      struct.setLiqfrecpag_Z(getgxTv_SdtLiquidacion_Liqfrecpag_Z());
      struct.setLiqperdes_Z(getgxTv_SdtLiquidacion_Liqperdes_Z());
      struct.setLiqperhas_Z(getgxTv_SdtLiquidacion_Liqperhas_Z());
      struct.setLiqtipotarifa_Z(getgxTv_SdtLiquidacion_Liqtipotarifa_Z());
      struct.setTliqcod_N(getgxTv_SdtLiquidacion_Tliqcod_N());
      struct.setLiqclase_N(getgxTv_SdtLiquidacion_Liqclase_N());
      struct.setLiqpdfestado_N(getgxTv_SdtLiquidacion_Liqpdfestado_N());
      struct.setLiqdepbancod_N(getgxTv_SdtLiquidacion_Liqdepbancod_N());
      struct.setLiqrelnro_N(getgxTv_SdtLiquidacion_Liqrelnro_N());
      struct.setLiqsac_N(getgxTv_SdtLiquidacion_Liqsac_N());
      struct.setLiqsaclog_N(getgxTv_SdtLiquidacion_Liqsaclog_N());
      return struct ;
   }

   private byte gxTv_SdtLiquidacion_N ;
   private byte gxTv_SdtLiquidacion_Liqpermes ;
   private byte gxTv_SdtLiquidacion_Liqestado ;
   private byte gxTv_SdtLiquidacion_Liqlsddepest ;
   private byte gxTv_SdtLiquidacion_Liqauxestado ;
   private byte gxTv_SdtLiquidacion_Liqcontrest ;
   private byte gxTv_SdtLiquidacion_Liqclase ;
   private byte gxTv_SdtLiquidacion_Liqdeppermes ;
   private byte gxTv_SdtLiquidacion_Liqfrecpag ;
   private byte gxTv_SdtLiquidacion_Liqpermes_Z ;
   private byte gxTv_SdtLiquidacion_Liqestado_Z ;
   private byte gxTv_SdtLiquidacion_Liqlsddepest_Z ;
   private byte gxTv_SdtLiquidacion_Liqauxestado_Z ;
   private byte gxTv_SdtLiquidacion_Liqcontrest_Z ;
   private byte gxTv_SdtLiquidacion_Liqclase_Z ;
   private byte gxTv_SdtLiquidacion_Liqdeppermes_Z ;
   private byte gxTv_SdtLiquidacion_Liqfrecpag_Z ;
   private byte gxTv_SdtLiquidacion_Tliqcod_N ;
   private byte gxTv_SdtLiquidacion_Liqclase_N ;
   private byte gxTv_SdtLiquidacion_Liqpdfestado_N ;
   private byte gxTv_SdtLiquidacion_Liqdepbancod_N ;
   private byte gxTv_SdtLiquidacion_Liqrelnro_N ;
   private byte gxTv_SdtLiquidacion_Liqsac_N ;
   private byte gxTv_SdtLiquidacion_Liqsaclog_N ;
   private short gxTv_SdtLiquidacion_Empcod ;
   private short gxTv_SdtLiquidacion_Liqperano ;
   private short gxTv_SdtLiquidacion_Liqcntleg ;
   private short gxTv_SdtLiquidacion_Liqdepperano ;
   private short gxTv_SdtLiquidacion_Initialized ;
   private short gxTv_SdtLiquidacion_Empcod_Z ;
   private short gxTv_SdtLiquidacion_Liqperano_Z ;
   private short gxTv_SdtLiquidacion_Liqcntleg_Z ;
   private short gxTv_SdtLiquidacion_Liqdepperano_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private int gxTv_SdtLiquidacion_Clicod ;
   private int gxTv_SdtLiquidacion_Liqnro ;
   private int gxTv_SdtLiquidacion_Liqrelnro ;
   private int gxTv_SdtLiquidacion_Clicod_Z ;
   private int gxTv_SdtLiquidacion_Liqnro_Z ;
   private int gxTv_SdtLiquidacion_Liqrelnro_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacion_Liqimpneto ;
   private java.math.BigDecimal gxTv_SdtLiquidacion_Liqimpdescuentos ;
   private java.math.BigDecimal gxTv_SdtLiquidacion_Liqimpretengan ;
   private java.math.BigDecimal gxTv_SdtLiquidacion_Liqimpbruto ;
   private java.math.BigDecimal gxTv_SdtLiquidacion_Liqpisoganancias ;
   private java.math.BigDecimal gxTv_SdtLiquidacion_Liqpisgansac ;
   private java.math.BigDecimal gxTv_SdtLiquidacion_Liqtopededinc ;
   private java.math.BigDecimal gxTv_SdtLiquidacion_Liqsegundos ;
   private java.math.BigDecimal gxTv_SdtLiquidacion_Liqimpneto_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacion_Liqimpdescuentos_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacion_Liqimpretengan_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacion_Liqimpbruto_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacion_Liqpisoganancias_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacion_Liqpisgansac_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacion_Liqtopededinc_Z ;
   private java.math.BigDecimal gxTv_SdtLiquidacion_Liqsegundos_Z ;
   private String gxTv_SdtLiquidacion_Tliqcod ;
   private String gxTv_SdtLiquidacion_Liqpdfestado ;
   private String gxTv_SdtLiquidacion_Liqpersindia ;
   private String gxTv_SdtLiquidacion_Liqperpalabra ;
   private String gxTv_SdtLiquidacion_Liqdepprvper ;
   private String gxTv_SdtLiquidacion_Liqdepbancod ;
   private String gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical ;
   private String gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal ;
   private String gxTv_SdtLiquidacion_Liqmodtra ;
   private String gxTv_SdtLiquidacion_Liqtipotarifa ;
   private String gxTv_SdtLiquidacion_Mode ;
   private String gxTv_SdtLiquidacion_Tliqcod_Z ;
   private String gxTv_SdtLiquidacion_Liqpdfestado_Z ;
   private String gxTv_SdtLiquidacion_Liqpersindia_Z ;
   private String gxTv_SdtLiquidacion_Liqperpalabra_Z ;
   private String gxTv_SdtLiquidacion_Liqdepprvper_Z ;
   private String gxTv_SdtLiquidacion_Liqdepbancod_Z ;
   private String gxTv_SdtLiquidacion_Liqrutapdftodosnombrevertical_Z ;
   private String gxTv_SdtLiquidacion_Liqrutapdftodosnombrehorizontal_Z ;
   private String gxTv_SdtLiquidacion_Liqmodtra_Z ;
   private String gxTv_SdtLiquidacion_Liqtipotarifa_Z ;
   private String sTagName ;
   private String sDateCnv ;
   private String sNumToPad ;
   private java.util.Date gxTv_SdtLiquidacion_Liqfecmod ;
   private java.util.Date gxTv_SdtLiquidacion_Liqfecimp ;
   private java.util.Date gxTv_SdtLiquidacion_Liqfecmod_Z ;
   private java.util.Date gxTv_SdtLiquidacion_Liqfecimp_Z ;
   private java.util.Date datetime_STZ ;
   private java.util.Date gxTv_SdtLiquidacion_Liqfecha ;
   private java.util.Date gxTv_SdtLiquidacion_Liqperiodo ;
   private java.util.Date gxTv_SdtLiquidacion_Liqfecpago ;
   private java.util.Date gxTv_SdtLiquidacion_Liqfeccre ;
   private java.util.Date gxTv_SdtLiquidacion_Liqdepprvfec ;
   private java.util.Date gxTv_SdtLiquidacion_Liqperultnorm ;
   private java.util.Date gxTv_SdtLiquidacion_Periodoliq ;
   private java.util.Date gxTv_SdtLiquidacion_Liqperdes ;
   private java.util.Date gxTv_SdtLiquidacion_Liqperhas ;
   private java.util.Date gxTv_SdtLiquidacion_Liqfecha_Z ;
   private java.util.Date gxTv_SdtLiquidacion_Liqperiodo_Z ;
   private java.util.Date gxTv_SdtLiquidacion_Liqfecpago_Z ;
   private java.util.Date gxTv_SdtLiquidacion_Liqfeccre_Z ;
   private java.util.Date gxTv_SdtLiquidacion_Liqdepprvfec_Z ;
   private java.util.Date gxTv_SdtLiquidacion_Liqperultnorm_Z ;
   private java.util.Date gxTv_SdtLiquidacion_Periodoliq_Z ;
   private java.util.Date gxTv_SdtLiquidacion_Liqperdes_Z ;
   private java.util.Date gxTv_SdtLiquidacion_Liqperhas_Z ;
   private boolean gxTv_SdtLiquidacion_Liqgeninter ;
   private boolean gxTv_SdtLiquidacion_Liqcontabilizada ;
   private boolean gxTv_SdtLiquidacion_Legespecificos ;
   private boolean gxTv_SdtLiquidacion_Liqsac ;
   private boolean gxTv_SdtLiquidacion_Liqcancel ;
   private boolean gxTv_SdtLiquidacion_Liqgeninter_Z ;
   private boolean gxTv_SdtLiquidacion_Liqcontabilizada_Z ;
   private boolean gxTv_SdtLiquidacion_Legespecificos_Z ;
   private boolean gxTv_SdtLiquidacion_Liqsac_Z ;
   private boolean gxTv_SdtLiquidacion_Liqcancel_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtLiquidacion_Liqlog ;
   private String gxTv_SdtLiquidacion_Empnom ;
   private String gxTv_SdtLiquidacion_Liqdescrip ;
   private String gxTv_SdtLiquidacion_Tliqdesc ;
   private String gxTv_SdtLiquidacion_Tliqdescaux ;
   private String gxTv_SdtLiquidacion_Liqusucre ;
   private String gxTv_SdtLiquidacion_Liqdepbandescrip ;
   private String gxTv_SdtLiquidacion_Liqusumod ;
   private String gxTv_SdtLiquidacion_Liqerror ;
   private String gxTv_SdtLiquidacion_Liqerroraux ;
   private String gxTv_SdtLiquidacion_Liqnombre ;
   private String gxTv_SdtLiquidacion_Liqlegajostxt ;
   private String gxTv_SdtLiquidacion_Liqrutapdftodosvertical ;
   private String gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal ;
   private String gxTv_SdtLiquidacion_Liqsaclog ;
   private String gxTv_SdtLiquidacion_Empnom_Z ;
   private String gxTv_SdtLiquidacion_Liqdescrip_Z ;
   private String gxTv_SdtLiquidacion_Tliqdesc_Z ;
   private String gxTv_SdtLiquidacion_Tliqdescaux_Z ;
   private String gxTv_SdtLiquidacion_Liqusucre_Z ;
   private String gxTv_SdtLiquidacion_Liqdepbandescrip_Z ;
   private String gxTv_SdtLiquidacion_Liqusumod_Z ;
   private String gxTv_SdtLiquidacion_Liqerror_Z ;
   private String gxTv_SdtLiquidacion_Liqerroraux_Z ;
   private String gxTv_SdtLiquidacion_Liqnombre_Z ;
   private String gxTv_SdtLiquidacion_Liqlegajostxt_Z ;
   private String gxTv_SdtLiquidacion_Liqrutapdftodosvertical_Z ;
   private String gxTv_SdtLiquidacion_Liqrutapdftodoshorizontal_Z ;
   private String gxTv_SdtLiquidacion_Liqsaclog_Z ;
}

