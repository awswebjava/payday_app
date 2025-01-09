package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_datos_liq extends GxUserType
{
   public Sdtsdt_datos_liq( )
   {
      this(  new ModelContext(Sdtsdt_datos_liq.class));
   }

   public Sdtsdt_datos_liq( ModelContext context )
   {
      super( context, "Sdtsdt_datos_liq");
   }

   public Sdtsdt_datos_liq( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_datos_liq");
   }

   public Sdtsdt_datos_liq( StructSdtsdt_datos_liq struct )
   {
      this();
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
               gxTv_Sdtsdt_datos_liq_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpCod") )
            {
               gxTv_Sdtsdt_datos_liq_Empcod = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNro") )
            {
               gxTv_Sdtsdt_datos_liq_Liqnro = (int)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_Sdtsdt_datos_liq_Liqfecha = GXutil.nullDate() ;
                  gxTv_Sdtsdt_datos_liq_Liqfecha_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_datos_liq_Liqfecha_N = (byte)(0) ;
                  gxTv_Sdtsdt_datos_liq_Liqfecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
                  gxTv_Sdtsdt_datos_liq_Liqfecpago = GXutil.nullDate() ;
                  gxTv_Sdtsdt_datos_liq_Liqfecpago_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_datos_liq_Liqfecpago_N = (byte)(0) ;
                  gxTv_Sdtsdt_datos_liq_Liqfecpago = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDescrip") )
            {
               gxTv_Sdtsdt_datos_liq_Liqdescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqClase") )
            {
               gxTv_Sdtsdt_datos_liq_Liqclase = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqEstado") )
            {
               gxTv_Sdtsdt_datos_liq_Liqestado = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqCod") )
            {
               gxTv_Sdtsdt_datos_liq_Tliqcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AplicaA") )
            {
               gxTv_Sdtsdt_datos_liq_Aplicaa = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LegNumero_obj") )
            {
               gxTv_Sdtsdt_datos_liq_Legnumero_obj = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDepBanCod") )
            {
               gxTv_Sdtsdt_datos_liq_Liqdepbancod = oReader.getValue() ;
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
                  gxTv_Sdtsdt_datos_liq_Liqdepprvfec = GXutil.nullDate() ;
                  gxTv_Sdtsdt_datos_liq_Liqdepprvfec_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_datos_liq_Liqdepprvfec_N = (byte)(0) ;
                  gxTv_Sdtsdt_datos_liq_Liqdepprvfec = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDepPerAno") )
            {
               gxTv_Sdtsdt_datos_liq_Liqdepperano = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDepPerMes") )
            {
               gxTv_Sdtsdt_datos_liq_Liqdeppermes = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerMes") )
            {
               gxTv_Sdtsdt_datos_liq_Liqpermes = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerAno") )
            {
               gxTv_Sdtsdt_datos_liq_Liqperano = (short)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_Sdtsdt_datos_liq_Liqfecimp = GXutil.resetTime( GXutil.nullDate() );
                  gxTv_Sdtsdt_datos_liq_Liqfecimp_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_datos_liq_Liqfecimp_N = (byte)(0) ;
                  gxTv_Sdtsdt_datos_liq_Liqfecimp = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "parmLiqPerPalabra") )
            {
               gxTv_Sdtsdt_datos_liq_Parmliqperpalabra = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqNombre") )
            {
               gxTv_Sdtsdt_datos_liq_Liqnombre = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqRelNro") )
            {
               gxTv_Sdtsdt_datos_liq_Liqrelnro = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ClientId") )
            {
               gxTv_Sdtsdt_datos_liq_Clientid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqSac") )
            {
               gxTv_Sdtsdt_datos_liq_Liqsac = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqSacLog") )
            {
               gxTv_Sdtsdt_datos_liq_Liqsaclog = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "replicaNro") )
            {
               gxTv_Sdtsdt_datos_liq_Replicanro = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "env") )
            {
               gxTv_Sdtsdt_datos_liq_Env = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "daemonUUID") )
            {
               gxTv_Sdtsdt_datos_liq_Daemonuuid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "reLiquidacion") )
            {
               gxTv_Sdtsdt_datos_liq_Reliquidacion = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqModTra") )
            {
               gxTv_Sdtsdt_datos_liq_Liqmodtra = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqFrecPag") )
            {
               gxTv_Sdtsdt_datos_liq_Liqfrecpag = (byte)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_Sdtsdt_datos_liq_Liqperdes = GXutil.nullDate() ;
                  gxTv_Sdtsdt_datos_liq_Liqperdes_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_datos_liq_Liqperdes_N = (byte)(0) ;
                  gxTv_Sdtsdt_datos_liq_Liqperdes = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
                  gxTv_Sdtsdt_datos_liq_Liqperhas = GXutil.nullDate() ;
                  gxTv_Sdtsdt_datos_liq_Liqperhas_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_datos_liq_Liqperhas_N = (byte)(0) ;
                  gxTv_Sdtsdt_datos_liq_Liqperhas = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_Sdtsdt_datos_liq_Liqtipotarifa = oReader.getValue() ;
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
         sName = "sdt_datos_liq" ;
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
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtsdt_datos_liq_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpCod", GXutil.trim( GXutil.str( gxTv_Sdtsdt_datos_liq_Empcod, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqNro", GXutil.trim( GXutil.str( gxTv_Sdtsdt_datos_liq_Liqnro, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtsdt_datos_liq_Liqfecha)) && ( gxTv_Sdtsdt_datos_liq_Liqfecha_N == 1 ) )
      {
         oWriter.writeElement("LiqFecha", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_datos_liq_Liqfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_datos_liq_Liqfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_datos_liq_Liqfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqFecha", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtsdt_datos_liq_Liqfecpago)) && ( gxTv_Sdtsdt_datos_liq_Liqfecpago_N == 1 ) )
      {
         oWriter.writeElement("LiqFecPago", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_datos_liq_Liqfecpago), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_datos_liq_Liqfecpago), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_datos_liq_Liqfecpago), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqFecPago", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("LiqDescrip", gxTv_Sdtsdt_datos_liq_Liqdescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqClase", GXutil.trim( GXutil.str( gxTv_Sdtsdt_datos_liq_Liqclase, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqEstado", GXutil.trim( GXutil.str( gxTv_Sdtsdt_datos_liq_Liqestado, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TLiqCod", gxTv_Sdtsdt_datos_liq_Tliqcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AplicaA", gxTv_Sdtsdt_datos_liq_Aplicaa);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LegNumero_obj", gxTv_Sdtsdt_datos_liq_Legnumero_obj);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqDepBanCod", gxTv_Sdtsdt_datos_liq_Liqdepbancod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtsdt_datos_liq_Liqdepprvfec)) && ( gxTv_Sdtsdt_datos_liq_Liqdepprvfec_N == 1 ) )
      {
         oWriter.writeElement("LiqDepPrvFec", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_datos_liq_Liqdepprvfec), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_datos_liq_Liqdepprvfec), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_datos_liq_Liqdepprvfec), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqDepPrvFec", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("LiqDepPerAno", GXutil.trim( GXutil.str( gxTv_Sdtsdt_datos_liq_Liqdepperano, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqDepPerMes", GXutil.trim( GXutil.str( gxTv_Sdtsdt_datos_liq_Liqdeppermes, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqPerMes", GXutil.trim( GXutil.str( gxTv_Sdtsdt_datos_liq_Liqpermes, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqPerAno", GXutil.trim( GXutil.str( gxTv_Sdtsdt_datos_liq_Liqperano, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.nullDate(), gxTv_Sdtsdt_datos_liq_Liqfecimp) && ( gxTv_Sdtsdt_datos_liq_Liqfecimp_N == 1 ) )
      {
         oWriter.writeElement("LiqFecImp", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_datos_liq_Liqfecimp), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_datos_liq_Liqfecimp), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_datos_liq_Liqfecimp), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_Sdtsdt_datos_liq_Liqfecimp), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_Sdtsdt_datos_liq_Liqfecimp), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_Sdtsdt_datos_liq_Liqfecimp), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqFecImp", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("parmLiqPerPalabra", gxTv_Sdtsdt_datos_liq_Parmliqperpalabra);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqNombre", gxTv_Sdtsdt_datos_liq_Liqnombre);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqRelNro", GXutil.trim( GXutil.str( gxTv_Sdtsdt_datos_liq_Liqrelnro, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ClientId", gxTv_Sdtsdt_datos_liq_Clientid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqSac", GXutil.booltostr( gxTv_Sdtsdt_datos_liq_Liqsac));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqSacLog", gxTv_Sdtsdt_datos_liq_Liqsaclog);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("replicaNro", GXutil.trim( GXutil.str( gxTv_Sdtsdt_datos_liq_Replicanro, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("env", gxTv_Sdtsdt_datos_liq_Env);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("daemonUUID", gxTv_Sdtsdt_datos_liq_Daemonuuid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("reLiquidacion", GXutil.booltostr( gxTv_Sdtsdt_datos_liq_Reliquidacion));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqModTra", gxTv_Sdtsdt_datos_liq_Liqmodtra);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqFrecPag", GXutil.trim( GXutil.str( gxTv_Sdtsdt_datos_liq_Liqfrecpag, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtsdt_datos_liq_Liqperdes)) && ( gxTv_Sdtsdt_datos_liq_Liqperdes_N == 1 ) )
      {
         oWriter.writeElement("LiqPerDes", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_datos_liq_Liqperdes), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_datos_liq_Liqperdes), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_datos_liq_Liqperdes), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqPerDes", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtsdt_datos_liq_Liqperhas)) && ( gxTv_Sdtsdt_datos_liq_Liqperhas_N == 1 ) )
      {
         oWriter.writeElement("LiqPerHas", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_datos_liq_Liqperhas), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_datos_liq_Liqperhas), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_datos_liq_Liqperhas), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqPerHas", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("LiqTipoTarifa", gxTv_Sdtsdt_datos_liq_Liqtipotarifa);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
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
      AddObjectProperty("CliCod", gxTv_Sdtsdt_datos_liq_Clicod, false, false);
      AddObjectProperty("EmpCod", gxTv_Sdtsdt_datos_liq_Empcod, false, false);
      AddObjectProperty("LiqNro", gxTv_Sdtsdt_datos_liq_Liqnro, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_datos_liq_Liqfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_datos_liq_Liqfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_datos_liq_Liqfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqFecha", sDateCnv, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_datos_liq_Liqfecpago), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_datos_liq_Liqfecpago), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_datos_liq_Liqfecpago), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqFecPago", sDateCnv, false, false);
      AddObjectProperty("LiqDescrip", gxTv_Sdtsdt_datos_liq_Liqdescrip, false, false);
      AddObjectProperty("LiqClase", gxTv_Sdtsdt_datos_liq_Liqclase, false, false);
      AddObjectProperty("LiqEstado", gxTv_Sdtsdt_datos_liq_Liqestado, false, false);
      AddObjectProperty("TLiqCod", gxTv_Sdtsdt_datos_liq_Tliqcod, false, false);
      AddObjectProperty("AplicaA", gxTv_Sdtsdt_datos_liq_Aplicaa, false, false);
      AddObjectProperty("LegNumero_obj", gxTv_Sdtsdt_datos_liq_Legnumero_obj, false, false);
      AddObjectProperty("LiqDepBanCod", gxTv_Sdtsdt_datos_liq_Liqdepbancod, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_datos_liq_Liqdepprvfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_datos_liq_Liqdepprvfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_datos_liq_Liqdepprvfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqDepPrvFec", sDateCnv, false, false);
      AddObjectProperty("LiqDepPerAno", gxTv_Sdtsdt_datos_liq_Liqdepperano, false, false);
      AddObjectProperty("LiqDepPerMes", gxTv_Sdtsdt_datos_liq_Liqdeppermes, false, false);
      AddObjectProperty("LiqPerMes", gxTv_Sdtsdt_datos_liq_Liqpermes, false, false);
      AddObjectProperty("LiqPerAno", gxTv_Sdtsdt_datos_liq_Liqperano, false, false);
      datetime_STZ = gxTv_Sdtsdt_datos_liq_Liqfecimp ;
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
      AddObjectProperty("LiqFecImp", sDateCnv, false, false);
      AddObjectProperty("parmLiqPerPalabra", gxTv_Sdtsdt_datos_liq_Parmliqperpalabra, false, false);
      AddObjectProperty("LiqNombre", gxTv_Sdtsdt_datos_liq_Liqnombre, false, false);
      AddObjectProperty("LiqRelNro", gxTv_Sdtsdt_datos_liq_Liqrelnro, false, false);
      AddObjectProperty("ClientId", gxTv_Sdtsdt_datos_liq_Clientid, false, false);
      AddObjectProperty("LiqSac", gxTv_Sdtsdt_datos_liq_Liqsac, false, false);
      AddObjectProperty("LiqSacLog", gxTv_Sdtsdt_datos_liq_Liqsaclog, false, false);
      AddObjectProperty("replicaNro", gxTv_Sdtsdt_datos_liq_Replicanro, false, false);
      AddObjectProperty("env", gxTv_Sdtsdt_datos_liq_Env, false, false);
      AddObjectProperty("daemonUUID", gxTv_Sdtsdt_datos_liq_Daemonuuid, false, false);
      AddObjectProperty("reLiquidacion", gxTv_Sdtsdt_datos_liq_Reliquidacion, false, false);
      AddObjectProperty("LiqModTra", gxTv_Sdtsdt_datos_liq_Liqmodtra, false, false);
      AddObjectProperty("LiqFrecPag", gxTv_Sdtsdt_datos_liq_Liqfrecpag, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_datos_liq_Liqperdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_datos_liq_Liqperdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_datos_liq_Liqperdes), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqPerDes", sDateCnv, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_datos_liq_Liqperhas), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_datos_liq_Liqperhas), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_datos_liq_Liqperhas), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqPerHas", sDateCnv, false, false);
      AddObjectProperty("LiqTipoTarifa", gxTv_Sdtsdt_datos_liq_Liqtipotarifa, false, false);
   }

   public int getgxTv_Sdtsdt_datos_liq_Clicod( )
   {
      return gxTv_Sdtsdt_datos_liq_Clicod ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Clicod( int value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Clicod = value ;
   }

   public short getgxTv_Sdtsdt_datos_liq_Empcod( )
   {
      return gxTv_Sdtsdt_datos_liq_Empcod ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Empcod( short value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Empcod = value ;
   }

   public int getgxTv_Sdtsdt_datos_liq_Liqnro( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqnro ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqnro( int value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqnro = value ;
   }

   public java.util.Date getgxTv_Sdtsdt_datos_liq_Liqfecha( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqfecha ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqfecha( java.util.Date value )
   {
      gxTv_Sdtsdt_datos_liq_Liqfecha_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqfecha = value ;
   }

   public java.util.Date getgxTv_Sdtsdt_datos_liq_Liqfecpago( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqfecpago ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqfecpago( java.util.Date value )
   {
      gxTv_Sdtsdt_datos_liq_Liqfecpago_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqfecpago = value ;
   }

   public String getgxTv_Sdtsdt_datos_liq_Liqdescrip( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqdescrip ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqdescrip( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqdescrip = value ;
   }

   public byte getgxTv_Sdtsdt_datos_liq_Liqclase( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqclase ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqclase( byte value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqclase = value ;
   }

   public byte getgxTv_Sdtsdt_datos_liq_Liqestado( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqestado ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqestado( byte value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqestado = value ;
   }

   public String getgxTv_Sdtsdt_datos_liq_Tliqcod( )
   {
      return gxTv_Sdtsdt_datos_liq_Tliqcod ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Tliqcod( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Tliqcod = value ;
   }

   public String getgxTv_Sdtsdt_datos_liq_Aplicaa( )
   {
      return gxTv_Sdtsdt_datos_liq_Aplicaa ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Aplicaa( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Aplicaa = value ;
   }

   public String getgxTv_Sdtsdt_datos_liq_Legnumero_obj( )
   {
      return gxTv_Sdtsdt_datos_liq_Legnumero_obj ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Legnumero_obj( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Legnumero_obj = value ;
   }

   public String getgxTv_Sdtsdt_datos_liq_Liqdepbancod( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqdepbancod ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqdepbancod( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqdepbancod = value ;
   }

   public java.util.Date getgxTv_Sdtsdt_datos_liq_Liqdepprvfec( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqdepprvfec ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqdepprvfec( java.util.Date value )
   {
      gxTv_Sdtsdt_datos_liq_Liqdepprvfec_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqdepprvfec = value ;
   }

   public short getgxTv_Sdtsdt_datos_liq_Liqdepperano( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqdepperano ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqdepperano( short value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqdepperano = value ;
   }

   public byte getgxTv_Sdtsdt_datos_liq_Liqdeppermes( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqdeppermes ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqdeppermes( byte value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqdeppermes = value ;
   }

   public byte getgxTv_Sdtsdt_datos_liq_Liqpermes( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqpermes ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqpermes( byte value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqpermes = value ;
   }

   public short getgxTv_Sdtsdt_datos_liq_Liqperano( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqperano ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqperano( short value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqperano = value ;
   }

   public java.util.Date getgxTv_Sdtsdt_datos_liq_Liqfecimp( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqfecimp ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqfecimp( java.util.Date value )
   {
      gxTv_Sdtsdt_datos_liq_Liqfecimp_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqfecimp = value ;
   }

   public String getgxTv_Sdtsdt_datos_liq_Parmliqperpalabra( )
   {
      return gxTv_Sdtsdt_datos_liq_Parmliqperpalabra ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Parmliqperpalabra( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Parmliqperpalabra = value ;
   }

   public String getgxTv_Sdtsdt_datos_liq_Liqnombre( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqnombre ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqnombre( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqnombre = value ;
   }

   public int getgxTv_Sdtsdt_datos_liq_Liqrelnro( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqrelnro ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqrelnro( int value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqrelnro = value ;
   }

   public String getgxTv_Sdtsdt_datos_liq_Clientid( )
   {
      return gxTv_Sdtsdt_datos_liq_Clientid ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Clientid( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Clientid = value ;
   }

   public boolean getgxTv_Sdtsdt_datos_liq_Liqsac( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqsac ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqsac( boolean value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqsac = value ;
   }

   public String getgxTv_Sdtsdt_datos_liq_Liqsaclog( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqsaclog ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqsaclog( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqsaclog = value ;
   }

   public short getgxTv_Sdtsdt_datos_liq_Replicanro( )
   {
      return gxTv_Sdtsdt_datos_liq_Replicanro ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Replicanro( short value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Replicanro = value ;
   }

   public String getgxTv_Sdtsdt_datos_liq_Env( )
   {
      return gxTv_Sdtsdt_datos_liq_Env ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Env( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Env = value ;
   }

   public String getgxTv_Sdtsdt_datos_liq_Daemonuuid( )
   {
      return gxTv_Sdtsdt_datos_liq_Daemonuuid ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Daemonuuid( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Daemonuuid = value ;
   }

   public boolean getgxTv_Sdtsdt_datos_liq_Reliquidacion( )
   {
      return gxTv_Sdtsdt_datos_liq_Reliquidacion ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Reliquidacion( boolean value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Reliquidacion = value ;
   }

   public String getgxTv_Sdtsdt_datos_liq_Liqmodtra( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqmodtra ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqmodtra( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqmodtra = value ;
   }

   public byte getgxTv_Sdtsdt_datos_liq_Liqfrecpag( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqfrecpag ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqfrecpag( byte value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqfrecpag = value ;
   }

   public java.util.Date getgxTv_Sdtsdt_datos_liq_Liqperdes( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqperdes ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqperdes( java.util.Date value )
   {
      gxTv_Sdtsdt_datos_liq_Liqperdes_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqperdes = value ;
   }

   public java.util.Date getgxTv_Sdtsdt_datos_liq_Liqperhas( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqperhas ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqperhas( java.util.Date value )
   {
      gxTv_Sdtsdt_datos_liq_Liqperhas_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqperhas = value ;
   }

   public String getgxTv_Sdtsdt_datos_liq_Liqtipotarifa( )
   {
      return gxTv_Sdtsdt_datos_liq_Liqtipotarifa ;
   }

   public void setgxTv_Sdtsdt_datos_liq_Liqtipotarifa( String value )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(0) ;
      gxTv_Sdtsdt_datos_liq_Liqtipotarifa = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_datos_liq_N = (byte)(1) ;
      gxTv_Sdtsdt_datos_liq_Liqfecha = GXutil.nullDate() ;
      gxTv_Sdtsdt_datos_liq_Liqfecha_N = (byte)(1) ;
      gxTv_Sdtsdt_datos_liq_Liqfecpago = GXutil.nullDate() ;
      gxTv_Sdtsdt_datos_liq_Liqfecpago_N = (byte)(1) ;
      gxTv_Sdtsdt_datos_liq_Liqdescrip = "" ;
      gxTv_Sdtsdt_datos_liq_Tliqcod = "" ;
      gxTv_Sdtsdt_datos_liq_Aplicaa = "" ;
      gxTv_Sdtsdt_datos_liq_Legnumero_obj = "" ;
      gxTv_Sdtsdt_datos_liq_Liqdepbancod = "" ;
      gxTv_Sdtsdt_datos_liq_Liqdepprvfec = GXutil.nullDate() ;
      gxTv_Sdtsdt_datos_liq_Liqdepprvfec_N = (byte)(1) ;
      gxTv_Sdtsdt_datos_liq_Liqfecimp = GXutil.resetTime( GXutil.nullDate() );
      gxTv_Sdtsdt_datos_liq_Liqfecimp_N = (byte)(1) ;
      gxTv_Sdtsdt_datos_liq_Parmliqperpalabra = "" ;
      gxTv_Sdtsdt_datos_liq_Liqnombre = "" ;
      gxTv_Sdtsdt_datos_liq_Clientid = "" ;
      gxTv_Sdtsdt_datos_liq_Liqsaclog = "" ;
      gxTv_Sdtsdt_datos_liq_Env = "" ;
      gxTv_Sdtsdt_datos_liq_Daemonuuid = "" ;
      gxTv_Sdtsdt_datos_liq_Liqmodtra = "" ;
      gxTv_Sdtsdt_datos_liq_Liqperdes = GXutil.nullDate() ;
      gxTv_Sdtsdt_datos_liq_Liqperdes_N = (byte)(1) ;
      gxTv_Sdtsdt_datos_liq_Liqperhas = GXutil.nullDate() ;
      gxTv_Sdtsdt_datos_liq_Liqperhas_N = (byte)(1) ;
      gxTv_Sdtsdt_datos_liq_Liqtipotarifa = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_datos_liq_N ;
   }

   public web.Sdtsdt_datos_liq Clone( )
   {
      return (web.Sdtsdt_datos_liq)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_datos_liq struct )
   {
      setgxTv_Sdtsdt_datos_liq_Clicod(struct.getClicod());
      setgxTv_Sdtsdt_datos_liq_Empcod(struct.getEmpcod());
      setgxTv_Sdtsdt_datos_liq_Liqnro(struct.getLiqnro());
      if ( struct.gxTv_Sdtsdt_datos_liq_Liqfecha_N == 0 )
      {
         setgxTv_Sdtsdt_datos_liq_Liqfecha(struct.getLiqfecha());
      }
      if ( struct.gxTv_Sdtsdt_datos_liq_Liqfecpago_N == 0 )
      {
         setgxTv_Sdtsdt_datos_liq_Liqfecpago(struct.getLiqfecpago());
      }
      setgxTv_Sdtsdt_datos_liq_Liqdescrip(struct.getLiqdescrip());
      setgxTv_Sdtsdt_datos_liq_Liqclase(struct.getLiqclase());
      setgxTv_Sdtsdt_datos_liq_Liqestado(struct.getLiqestado());
      setgxTv_Sdtsdt_datos_liq_Tliqcod(struct.getTliqcod());
      setgxTv_Sdtsdt_datos_liq_Aplicaa(struct.getAplicaa());
      setgxTv_Sdtsdt_datos_liq_Legnumero_obj(struct.getLegnumero_obj());
      setgxTv_Sdtsdt_datos_liq_Liqdepbancod(struct.getLiqdepbancod());
      if ( struct.gxTv_Sdtsdt_datos_liq_Liqdepprvfec_N == 0 )
      {
         setgxTv_Sdtsdt_datos_liq_Liqdepprvfec(struct.getLiqdepprvfec());
      }
      setgxTv_Sdtsdt_datos_liq_Liqdepperano(struct.getLiqdepperano());
      setgxTv_Sdtsdt_datos_liq_Liqdeppermes(struct.getLiqdeppermes());
      setgxTv_Sdtsdt_datos_liq_Liqpermes(struct.getLiqpermes());
      setgxTv_Sdtsdt_datos_liq_Liqperano(struct.getLiqperano());
      if ( struct.gxTv_Sdtsdt_datos_liq_Liqfecimp_N == 0 )
      {
         setgxTv_Sdtsdt_datos_liq_Liqfecimp(struct.getLiqfecimp());
      }
      setgxTv_Sdtsdt_datos_liq_Parmliqperpalabra(struct.getParmliqperpalabra());
      setgxTv_Sdtsdt_datos_liq_Liqnombre(struct.getLiqnombre());
      setgxTv_Sdtsdt_datos_liq_Liqrelnro(struct.getLiqrelnro());
      setgxTv_Sdtsdt_datos_liq_Clientid(struct.getClientid());
      setgxTv_Sdtsdt_datos_liq_Liqsac(struct.getLiqsac());
      setgxTv_Sdtsdt_datos_liq_Liqsaclog(struct.getLiqsaclog());
      setgxTv_Sdtsdt_datos_liq_Replicanro(struct.getReplicanro());
      setgxTv_Sdtsdt_datos_liq_Env(struct.getEnv());
      setgxTv_Sdtsdt_datos_liq_Daemonuuid(struct.getDaemonuuid());
      setgxTv_Sdtsdt_datos_liq_Reliquidacion(struct.getReliquidacion());
      setgxTv_Sdtsdt_datos_liq_Liqmodtra(struct.getLiqmodtra());
      setgxTv_Sdtsdt_datos_liq_Liqfrecpag(struct.getLiqfrecpag());
      if ( struct.gxTv_Sdtsdt_datos_liq_Liqperdes_N == 0 )
      {
         setgxTv_Sdtsdt_datos_liq_Liqperdes(struct.getLiqperdes());
      }
      if ( struct.gxTv_Sdtsdt_datos_liq_Liqperhas_N == 0 )
      {
         setgxTv_Sdtsdt_datos_liq_Liqperhas(struct.getLiqperhas());
      }
      setgxTv_Sdtsdt_datos_liq_Liqtipotarifa(struct.getLiqtipotarifa());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_datos_liq getStruct( )
   {
      web.StructSdtsdt_datos_liq struct = new web.StructSdtsdt_datos_liq ();
      struct.setClicod(getgxTv_Sdtsdt_datos_liq_Clicod());
      struct.setEmpcod(getgxTv_Sdtsdt_datos_liq_Empcod());
      struct.setLiqnro(getgxTv_Sdtsdt_datos_liq_Liqnro());
      if ( gxTv_Sdtsdt_datos_liq_Liqfecha_N == 0 )
      {
         struct.setLiqfecha(getgxTv_Sdtsdt_datos_liq_Liqfecha());
      }
      if ( gxTv_Sdtsdt_datos_liq_Liqfecpago_N == 0 )
      {
         struct.setLiqfecpago(getgxTv_Sdtsdt_datos_liq_Liqfecpago());
      }
      struct.setLiqdescrip(getgxTv_Sdtsdt_datos_liq_Liqdescrip());
      struct.setLiqclase(getgxTv_Sdtsdt_datos_liq_Liqclase());
      struct.setLiqestado(getgxTv_Sdtsdt_datos_liq_Liqestado());
      struct.setTliqcod(getgxTv_Sdtsdt_datos_liq_Tliqcod());
      struct.setAplicaa(getgxTv_Sdtsdt_datos_liq_Aplicaa());
      struct.setLegnumero_obj(getgxTv_Sdtsdt_datos_liq_Legnumero_obj());
      struct.setLiqdepbancod(getgxTv_Sdtsdt_datos_liq_Liqdepbancod());
      if ( gxTv_Sdtsdt_datos_liq_Liqdepprvfec_N == 0 )
      {
         struct.setLiqdepprvfec(getgxTv_Sdtsdt_datos_liq_Liqdepprvfec());
      }
      struct.setLiqdepperano(getgxTv_Sdtsdt_datos_liq_Liqdepperano());
      struct.setLiqdeppermes(getgxTv_Sdtsdt_datos_liq_Liqdeppermes());
      struct.setLiqpermes(getgxTv_Sdtsdt_datos_liq_Liqpermes());
      struct.setLiqperano(getgxTv_Sdtsdt_datos_liq_Liqperano());
      if ( gxTv_Sdtsdt_datos_liq_Liqfecimp_N == 0 )
      {
         struct.setLiqfecimp(getgxTv_Sdtsdt_datos_liq_Liqfecimp());
      }
      struct.setParmliqperpalabra(getgxTv_Sdtsdt_datos_liq_Parmliqperpalabra());
      struct.setLiqnombre(getgxTv_Sdtsdt_datos_liq_Liqnombre());
      struct.setLiqrelnro(getgxTv_Sdtsdt_datos_liq_Liqrelnro());
      struct.setClientid(getgxTv_Sdtsdt_datos_liq_Clientid());
      struct.setLiqsac(getgxTv_Sdtsdt_datos_liq_Liqsac());
      struct.setLiqsaclog(getgxTv_Sdtsdt_datos_liq_Liqsaclog());
      struct.setReplicanro(getgxTv_Sdtsdt_datos_liq_Replicanro());
      struct.setEnv(getgxTv_Sdtsdt_datos_liq_Env());
      struct.setDaemonuuid(getgxTv_Sdtsdt_datos_liq_Daemonuuid());
      struct.setReliquidacion(getgxTv_Sdtsdt_datos_liq_Reliquidacion());
      struct.setLiqmodtra(getgxTv_Sdtsdt_datos_liq_Liqmodtra());
      struct.setLiqfrecpag(getgxTv_Sdtsdt_datos_liq_Liqfrecpag());
      if ( gxTv_Sdtsdt_datos_liq_Liqperdes_N == 0 )
      {
         struct.setLiqperdes(getgxTv_Sdtsdt_datos_liq_Liqperdes());
      }
      if ( gxTv_Sdtsdt_datos_liq_Liqperhas_N == 0 )
      {
         struct.setLiqperhas(getgxTv_Sdtsdt_datos_liq_Liqperhas());
      }
      struct.setLiqtipotarifa(getgxTv_Sdtsdt_datos_liq_Liqtipotarifa());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_datos_liq_N ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqfecha_N ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqfecpago_N ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqclase ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqestado ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqdepprvfec_N ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqdeppermes ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqpermes ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqfecimp_N ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqfrecpag ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqperdes_N ;
   protected byte gxTv_Sdtsdt_datos_liq_Liqperhas_N ;
   protected short gxTv_Sdtsdt_datos_liq_Empcod ;
   protected short gxTv_Sdtsdt_datos_liq_Liqdepperano ;
   protected short gxTv_Sdtsdt_datos_liq_Liqperano ;
   protected short gxTv_Sdtsdt_datos_liq_Replicanro ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtsdt_datos_liq_Clicod ;
   protected int gxTv_Sdtsdt_datos_liq_Liqnro ;
   protected int gxTv_Sdtsdt_datos_liq_Liqrelnro ;
   protected String gxTv_Sdtsdt_datos_liq_Tliqcod ;
   protected String gxTv_Sdtsdt_datos_liq_Aplicaa ;
   protected String gxTv_Sdtsdt_datos_liq_Liqdepbancod ;
   protected String gxTv_Sdtsdt_datos_liq_Parmliqperpalabra ;
   protected String gxTv_Sdtsdt_datos_liq_Env ;
   protected String gxTv_Sdtsdt_datos_liq_Daemonuuid ;
   protected String gxTv_Sdtsdt_datos_liq_Liqmodtra ;
   protected String gxTv_Sdtsdt_datos_liq_Liqtipotarifa ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_Sdtsdt_datos_liq_Liqfecimp ;
   protected java.util.Date datetime_STZ ;
   protected java.util.Date gxTv_Sdtsdt_datos_liq_Liqfecha ;
   protected java.util.Date gxTv_Sdtsdt_datos_liq_Liqfecpago ;
   protected java.util.Date gxTv_Sdtsdt_datos_liq_Liqdepprvfec ;
   protected java.util.Date gxTv_Sdtsdt_datos_liq_Liqperdes ;
   protected java.util.Date gxTv_Sdtsdt_datos_liq_Liqperhas ;
   protected boolean gxTv_Sdtsdt_datos_liq_Liqsac ;
   protected boolean gxTv_Sdtsdt_datos_liq_Reliquidacion ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_datos_liq_Liqdescrip ;
   protected String gxTv_Sdtsdt_datos_liq_Legnumero_obj ;
   protected String gxTv_Sdtsdt_datos_liq_Liqnombre ;
   protected String gxTv_Sdtsdt_datos_liq_Clientid ;
   protected String gxTv_Sdtsdt_datos_liq_Liqsaclog ;
}

