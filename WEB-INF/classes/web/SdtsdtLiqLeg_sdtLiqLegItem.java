package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtsdtLiqLeg_sdtLiqLegItem extends GxUserType
{
   public SdtsdtLiqLeg_sdtLiqLegItem( )
   {
      this(  new ModelContext(SdtsdtLiqLeg_sdtLiqLegItem.class));
   }

   public SdtsdtLiqLeg_sdtLiqLegItem( ModelContext context )
   {
      super( context, "SdtsdtLiqLeg_sdtLiqLegItem");
   }

   public SdtsdtLiqLeg_sdtLiqLegItem( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle, context, "SdtsdtLiqLeg_sdtLiqLegItem");
   }

   public SdtsdtLiqLeg_sdtLiqLegItem( StructSdtsdtLiqLeg_sdtLiqLegItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "impLegNumero") )
            {
               gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Implegnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "LiqLegImpTotal") )
            {
               gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Liqlegimptotal = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "mioLegNumero") )
            {
               gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Miolegnumero = (int)(getnumericvalue(oReader.getValue())) ;
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
         sName = "sdtLiqLeg.sdtLiqLegItem" ;
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
      oWriter.writeElement("impLegNumero", GXutil.trim( GXutil.str( gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Implegnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("LiqLegImpTotal", GXutil.trim( GXutil.strNoRound( gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Liqlegimptotal, 14, 2)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("mioLegNumero", GXutil.trim( GXutil.str( gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Miolegnumero, 8, 0)));
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
      AddObjectProperty("impLegNumero", gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Implegnumero, false, false);
      AddObjectProperty("LiqLegImpTotal", gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Liqlegimptotal, false, false);
      AddObjectProperty("mioLegNumero", gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Miolegnumero, false, false);
   }

   public int getgxTv_SdtsdtLiqLeg_sdtLiqLegItem_Implegnumero( )
   {
      return gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Implegnumero ;
   }

   public void setgxTv_SdtsdtLiqLeg_sdtLiqLegItem_Implegnumero( int value )
   {
      gxTv_SdtsdtLiqLeg_sdtLiqLegItem_N = (byte)(0) ;
      gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Implegnumero = value ;
   }

   public java.math.BigDecimal getgxTv_SdtsdtLiqLeg_sdtLiqLegItem_Liqlegimptotal( )
   {
      return gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Liqlegimptotal ;
   }

   public void setgxTv_SdtsdtLiqLeg_sdtLiqLegItem_Liqlegimptotal( java.math.BigDecimal value )
   {
      gxTv_SdtsdtLiqLeg_sdtLiqLegItem_N = (byte)(0) ;
      gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Liqlegimptotal = value ;
   }

   public int getgxTv_SdtsdtLiqLeg_sdtLiqLegItem_Miolegnumero( )
   {
      return gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Miolegnumero ;
   }

   public void setgxTv_SdtsdtLiqLeg_sdtLiqLegItem_Miolegnumero( int value )
   {
      gxTv_SdtsdtLiqLeg_sdtLiqLegItem_N = (byte)(0) ;
      gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Miolegnumero = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtsdtLiqLeg_sdtLiqLegItem_N = (byte)(1) ;
      gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Liqlegimptotal = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtsdtLiqLeg_sdtLiqLegItem_N ;
   }

   public web.SdtsdtLiqLeg_sdtLiqLegItem Clone( )
   {
      return (web.SdtsdtLiqLeg_sdtLiqLegItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdtLiqLeg_sdtLiqLegItem struct )
   {
      setgxTv_SdtsdtLiqLeg_sdtLiqLegItem_Implegnumero(struct.getImplegnumero());
      setgxTv_SdtsdtLiqLeg_sdtLiqLegItem_Liqlegimptotal(struct.getLiqlegimptotal());
      setgxTv_SdtsdtLiqLeg_sdtLiqLegItem_Miolegnumero(struct.getMiolegnumero());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdtLiqLeg_sdtLiqLegItem getStruct( )
   {
      web.StructSdtsdtLiqLeg_sdtLiqLegItem struct = new web.StructSdtsdtLiqLeg_sdtLiqLegItem ();
      struct.setImplegnumero(getgxTv_SdtsdtLiqLeg_sdtLiqLegItem_Implegnumero());
      struct.setLiqlegimptotal(getgxTv_SdtsdtLiqLeg_sdtLiqLegItem_Liqlegimptotal());
      struct.setMiolegnumero(getgxTv_SdtsdtLiqLeg_sdtLiqLegItem_Miolegnumero());
      return struct ;
   }

   protected byte gxTv_SdtsdtLiqLeg_sdtLiqLegItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Implegnumero ;
   protected int gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Miolegnumero ;
   protected java.math.BigDecimal gxTv_SdtsdtLiqLeg_sdtLiqLegItem_Liqlegimptotal ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

