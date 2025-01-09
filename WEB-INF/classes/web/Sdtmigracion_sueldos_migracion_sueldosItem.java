package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtmigracion_sueldos_migracion_sueldosItem extends GxUserType
{
   public Sdtmigracion_sueldos_migracion_sueldosItem( )
   {
      this(  new ModelContext(Sdtmigracion_sueldos_migracion_sueldosItem.class));
   }

   public Sdtmigracion_sueldos_migracion_sueldosItem( ModelContext context )
   {
      super( context, "Sdtmigracion_sueldos_migracion_sueldosItem");
   }

   public Sdtmigracion_sueldos_migracion_sueldosItem( int remoteHandle ,
                                                      ModelContext context )
   {
      super( remoteHandle, context, "Sdtmigracion_sueldos_migracion_sueldosItem");
   }

   public Sdtmigracion_sueldos_migracion_sueldosItem( StructSdtmigracion_sueldos_migracion_sueldosItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "sueldo") )
            {
               gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "fecha") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha = GXutil.nullDate() ;
                  gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha_N = (byte)(1) ;
               }
               else
               {
                  gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha_N = (byte)(0) ;
                  gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
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
         sName = "migracion_sueldos.migracion_sueldosItem" ;
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
      oWriter.writeElement("sueldo", GXutil.trim( GXutil.strNoRound( gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha)) && ( gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha_N == 1 ) )
      {
         oWriter.writeElement("fecha", "");
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("fecha", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("sueldo", gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("fecha", sDateCnv, false, false);
   }

   public java.math.BigDecimal getgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo( )
   {
      return gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo ;
   }

   public void setgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo( java.math.BigDecimal value )
   {
      gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo = value ;
   }

   public java.util.Date getgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha( )
   {
      return gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha ;
   }

   public void setgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha( java.util.Date value )
   {
      gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha_N = (byte)(0) ;
      gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_N = (byte)(0) ;
      gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo = DecimalUtil.ZERO ;
      gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_N = (byte)(1) ;
      gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha = GXutil.nullDate() ;
      gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha_N = (byte)(1) ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_N ;
   }

   public web.Sdtmigracion_sueldos_migracion_sueldosItem Clone( )
   {
      return (web.Sdtmigracion_sueldos_migracion_sueldosItem)(clone()) ;
   }

   public void setStruct( web.StructSdtmigracion_sueldos_migracion_sueldosItem struct )
   {
      setgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo(struct.getSueldo());
      if ( struct.gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha_N == 0 )
      {
         setgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha(struct.getFecha());
      }
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtmigracion_sueldos_migracion_sueldosItem getStruct( )
   {
      web.StructSdtmigracion_sueldos_migracion_sueldosItem struct = new web.StructSdtmigracion_sueldos_migracion_sueldosItem ();
      struct.setSueldo(getgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo());
      if ( gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha_N == 0 )
      {
         struct.setFecha(getgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha());
      }
      return struct ;
   }

   protected byte gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_N ;
   protected byte gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha ;
   protected boolean readElement ;
   protected boolean formatError ;
}

