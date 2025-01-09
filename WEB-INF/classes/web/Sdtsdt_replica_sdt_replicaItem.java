package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_replica_sdt_replicaItem extends GxUserType
{
   public Sdtsdt_replica_sdt_replicaItem( )
   {
      this(  new ModelContext(Sdtsdt_replica_sdt_replicaItem.class));
   }

   public Sdtsdt_replica_sdt_replicaItem( ModelContext context )
   {
      super( context, "Sdtsdt_replica_sdt_replicaItem");
   }

   public Sdtsdt_replica_sdt_replicaItem( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_replica_sdt_replicaItem");
   }

   public Sdtsdt_replica_sdt_replicaItem( StructSdtsdt_replica_sdt_replicaItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqFecha") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha = GXutil.nullDate() ;
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha_N = (byte)(0) ;
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago = GXutil.nullDate() ;
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago_N = (byte)(0) ;
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqClase") )
            {
               gxTv_Sdtsdt_replica_sdt_replicaItem_Liqclase = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqCod") )
            {
               gxTv_Sdtsdt_replica_sdt_replicaItem_Tliqcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDepBanCod") )
            {
               gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepbancod = oReader.getValue() ;
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
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec = GXutil.nullDate() ;
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec_N = (byte)(0) ;
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
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
               gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepperano = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqDepPerMes") )
            {
               gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdeppermes = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerMes") )
            {
               gxTv_Sdtsdt_replica_sdt_replicaItem_Liqpermes = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerAno") )
            {
               gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperano = (short)(getnumericvalue(oReader.getValue())) ;
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
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp = GXutil.resetTime( GXutil.nullDate() );
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp_N = (byte)(0) ;
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp = localUtil.ymdhmsToT( (short)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 12, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 15, 2), "."))), (byte)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 18, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqPerPalabra") )
            {
               gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperpalabra = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqImpNeto") )
            {
               gxTv_Sdtsdt_replica_sdt_replicaItem_Liqimpneto = DecimalUtil.stringToDec( oReader.getValue()) ;
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
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo = GXutil.nullDate() ;
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo_N = (byte)(0) ;
                  gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Legajos") )
            {
               gxTv_Sdtsdt_replica_sdt_replicaItem_Legajos = oReader.getValue() ;
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
         sName = "sdt_replica.sdt_replicaItem" ;
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
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha)) && ( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha_N == 1 ) )
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
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqFecha", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago)) && ( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago_N == 1 ) )
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
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqFecPago", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("LiqClase", GXutil.trim( GXutil.str( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqclase, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TLiqCod", gxTv_Sdtsdt_replica_sdt_replicaItem_Tliqcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqDepBanCod", gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepbancod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec)) && ( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec_N == 1 ) )
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
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqDepPrvFec", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("LiqDepPerAno", GXutil.trim( GXutil.str( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepperano, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqDepPerMes", GXutil.trim( GXutil.str( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdeppermes, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqPerMes", GXutil.trim( GXutil.str( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqpermes, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqPerAno", GXutil.trim( GXutil.str( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperano, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.nullDate(), gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp) && ( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp_N == 1 ) )
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
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "T" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.hour( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.minute( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += ":" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.second( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqFecImp", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("LiqPerPalabra", gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperpalabra);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqImpNeto", GXutil.trim( GXutil.strNoRound( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqimpneto, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo)) && ( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo_N == 1 ) )
      {
         oWriter.writeElement("LiqPeriodo", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("LiqPeriodo", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeElement("Legajos", gxTv_Sdtsdt_replica_sdt_replicaItem_Legajos);
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
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqFecha", sDateCnv, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqFecPago", sDateCnv, false, false);
      AddObjectProperty("LiqClase", gxTv_Sdtsdt_replica_sdt_replicaItem_Liqclase, false, false);
      AddObjectProperty("TLiqCod", gxTv_Sdtsdt_replica_sdt_replicaItem_Tliqcod, false, false);
      AddObjectProperty("LiqDepBanCod", gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepbancod, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqDepPrvFec", sDateCnv, false, false);
      AddObjectProperty("LiqDepPerAno", gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepperano, false, false);
      AddObjectProperty("LiqDepPerMes", gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdeppermes, false, false);
      AddObjectProperty("LiqPerMes", gxTv_Sdtsdt_replica_sdt_replicaItem_Liqpermes, false, false);
      AddObjectProperty("LiqPerAno", gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperano, false, false);
      datetime_STZ = gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp ;
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
      AddObjectProperty("LiqPerPalabra", gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperpalabra, false, false);
      AddObjectProperty("LiqImpNeto", gxTv_Sdtsdt_replica_sdt_replicaItem_Liqimpneto, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("LiqPeriodo", sDateCnv, false, false);
      AddObjectProperty("Legajos", gxTv_Sdtsdt_replica_sdt_replicaItem_Legajos, false, false);
   }

   public java.util.Date getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha ;
   }

   public void setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha( java.util.Date value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha = value ;
   }

   public java.util.Date getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago ;
   }

   public void setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago( java.util.Date value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago = value ;
   }

   public byte getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqclase( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqclase ;
   }

   public void setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqclase( byte value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqclase = value ;
   }

   public String getgxTv_Sdtsdt_replica_sdt_replicaItem_Tliqcod( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Tliqcod ;
   }

   public void setgxTv_Sdtsdt_replica_sdt_replicaItem_Tliqcod( String value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Tliqcod = value ;
   }

   public String getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepbancod( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepbancod ;
   }

   public void setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepbancod( String value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepbancod = value ;
   }

   public java.util.Date getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec ;
   }

   public void setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec( java.util.Date value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec = value ;
   }

   public short getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepperano( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepperano ;
   }

   public void setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepperano( short value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepperano = value ;
   }

   public byte getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqdeppermes( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdeppermes ;
   }

   public void setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqdeppermes( byte value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdeppermes = value ;
   }

   public byte getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqpermes( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqpermes ;
   }

   public void setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqpermes( byte value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqpermes = value ;
   }

   public short getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqperano( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperano ;
   }

   public void setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqperano( short value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperano = value ;
   }

   public java.util.Date getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp ;
   }

   public void setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp( java.util.Date value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp = value ;
   }

   public String getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqperpalabra( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperpalabra ;
   }

   public void setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqperpalabra( String value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperpalabra = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqimpneto( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqimpneto ;
   }

   public void setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqimpneto( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqimpneto = value ;
   }

   public java.util.Date getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo ;
   }

   public void setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo( java.util.Date value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo = value ;
   }

   public String getgxTv_Sdtsdt_replica_sdt_replicaItem_Legajos( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_Legajos ;
   }

   public void setgxTv_Sdtsdt_replica_sdt_replicaItem_Legajos( String value )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(0) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Legajos = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha = GXutil.nullDate() ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha_N = (byte)(1) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_N = (byte)(1) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago = GXutil.nullDate() ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago_N = (byte)(1) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Tliqcod = "" ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepbancod = "" ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec = GXutil.nullDate() ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec_N = (byte)(1) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp = GXutil.resetTime( GXutil.nullDate() );
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp_N = (byte)(1) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperpalabra = "" ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqimpneto = DecimalUtil.ZERO ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo = GXutil.nullDate() ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo_N = (byte)(1) ;
      gxTv_Sdtsdt_replica_sdt_replicaItem_Legajos = "" ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
      datetime_STZ = GXutil.resetTime( GXutil.nullDate() );
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_replica_sdt_replicaItem_N ;
   }

   public web.Sdtsdt_replica_sdt_replicaItem Clone( )
   {
      return (web.Sdtsdt_replica_sdt_replicaItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_replica_sdt_replicaItem struct )
   {
      if ( struct.gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha_N == 0 )
      {
         setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha(struct.getLiqfecha());
      }
      if ( struct.gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago_N == 0 )
      {
         setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago(struct.getLiqfecpago());
      }
      setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqclase(struct.getLiqclase());
      setgxTv_Sdtsdt_replica_sdt_replicaItem_Tliqcod(struct.getTliqcod());
      setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepbancod(struct.getLiqdepbancod());
      if ( struct.gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec_N == 0 )
      {
         setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec(struct.getLiqdepprvfec());
      }
      setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepperano(struct.getLiqdepperano());
      setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqdeppermes(struct.getLiqdeppermes());
      setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqpermes(struct.getLiqpermes());
      setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqperano(struct.getLiqperano());
      if ( struct.gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp_N == 0 )
      {
         setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp(struct.getLiqfecimp());
      }
      setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqperpalabra(struct.getLiqperpalabra());
      setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqimpneto(struct.getLiqimpneto());
      if ( struct.gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo_N == 0 )
      {
         setgxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo(struct.getLiqperiodo());
      }
      setgxTv_Sdtsdt_replica_sdt_replicaItem_Legajos(struct.getLegajos());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_replica_sdt_replicaItem getStruct( )
   {
      web.StructSdtsdt_replica_sdt_replicaItem struct = new web.StructSdtsdt_replica_sdt_replicaItem ();
      if ( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha_N == 0 )
      {
         struct.setLiqfecha(getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha());
      }
      if ( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago_N == 0 )
      {
         struct.setLiqfecpago(getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago());
      }
      struct.setLiqclase(getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqclase());
      struct.setTliqcod(getgxTv_Sdtsdt_replica_sdt_replicaItem_Tliqcod());
      struct.setLiqdepbancod(getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepbancod());
      if ( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec_N == 0 )
      {
         struct.setLiqdepprvfec(getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec());
      }
      struct.setLiqdepperano(getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepperano());
      struct.setLiqdeppermes(getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqdeppermes());
      struct.setLiqpermes(getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqpermes());
      struct.setLiqperano(getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqperano());
      if ( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp_N == 0 )
      {
         struct.setLiqfecimp(getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp());
      }
      struct.setLiqperpalabra(getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqperpalabra());
      struct.setLiqimpneto(getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqimpneto());
      if ( gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo_N == 0 )
      {
         struct.setLiqperiodo(getgxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo());
      }
      struct.setLegajos(getgxTv_Sdtsdt_replica_sdt_replicaItem_Legajos());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha_N ;
   protected byte gxTv_Sdtsdt_replica_sdt_replicaItem_N ;
   protected byte gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago_N ;
   protected byte gxTv_Sdtsdt_replica_sdt_replicaItem_Liqclase ;
   protected byte gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec_N ;
   protected byte gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdeppermes ;
   protected byte gxTv_Sdtsdt_replica_sdt_replicaItem_Liqpermes ;
   protected byte gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp_N ;
   protected byte gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo_N ;
   protected short gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepperano ;
   protected short gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperano ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtsdt_replica_sdt_replicaItem_Liqimpneto ;
   protected String gxTv_Sdtsdt_replica_sdt_replicaItem_Tliqcod ;
   protected String gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepbancod ;
   protected String gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperpalabra ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecimp ;
   protected java.util.Date datetime_STZ ;
   protected java.util.Date gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecha ;
   protected java.util.Date gxTv_Sdtsdt_replica_sdt_replicaItem_Liqfecpago ;
   protected java.util.Date gxTv_Sdtsdt_replica_sdt_replicaItem_Liqdepprvfec ;
   protected java.util.Date gxTv_Sdtsdt_replica_sdt_replicaItem_Liqperiodo ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_replica_sdt_replicaItem_Legajos ;
}

