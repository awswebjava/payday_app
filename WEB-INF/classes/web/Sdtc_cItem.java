package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtc_cItem extends GxUserType
{
   public Sdtc_cItem( )
   {
      this(  new ModelContext(Sdtc_cItem.class));
   }

   public Sdtc_cItem( ModelContext context )
   {
      super( context, "Sdtc_cItem");
   }

   public Sdtc_cItem( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle, context, "Sdtc_cItem");
   }

   public Sdtc_cItem( StructSdtc_cItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att1") )
            {
               gxTv_Sdtc_cItem_Att1 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att2") )
            {
               gxTv_Sdtc_cItem_Att2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att3") )
            {
               gxTv_Sdtc_cItem_Att3 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att4") )
            {
               gxTv_Sdtc_cItem_Att4 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att5") )
            {
               gxTv_Sdtc_cItem_Att5 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att6") )
            {
               gxTv_Sdtc_cItem_Att6 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att7") )
            {
               gxTv_Sdtc_cItem_Att7 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att8") )
            {
               gxTv_Sdtc_cItem_Att8 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att9") )
            {
               gxTv_Sdtc_cItem_Att9 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att10") )
            {
               gxTv_Sdtc_cItem_Att10 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att11") )
            {
               gxTv_Sdtc_cItem_Att11 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att12") )
            {
               gxTv_Sdtc_cItem_Att12 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att13") )
            {
               gxTv_Sdtc_cItem_Att13 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att14") )
            {
               gxTv_Sdtc_cItem_Att14 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att15") )
            {
               gxTv_Sdtc_cItem_Att15 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att16") )
            {
               gxTv_Sdtc_cItem_Att16 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att17") )
            {
               gxTv_Sdtc_cItem_Att17 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att18") )
            {
               gxTv_Sdtc_cItem_Att18 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att19") )
            {
               gxTv_Sdtc_cItem_Att19 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att20") )
            {
               gxTv_Sdtc_cItem_Att20 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att21") )
            {
               gxTv_Sdtc_cItem_Att21 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att22") )
            {
               gxTv_Sdtc_cItem_Att22 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att23") )
            {
               gxTv_Sdtc_cItem_Att23 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att24") )
            {
               gxTv_Sdtc_cItem_Att24 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att25") )
            {
               gxTv_Sdtc_cItem_Att25 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att26") )
            {
               gxTv_Sdtc_cItem_Att26 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att27") )
            {
               gxTv_Sdtc_cItem_Att27 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att28") )
            {
               gxTv_Sdtc_cItem_Att28 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att29") )
            {
               gxTv_Sdtc_cItem_Att29 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att30") )
            {
               gxTv_Sdtc_cItem_Att30 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att31") )
            {
               gxTv_Sdtc_cItem_Att31 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att32") )
            {
               gxTv_Sdtc_cItem_Att32 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att33") )
            {
               gxTv_Sdtc_cItem_Att33 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att34") )
            {
               gxTv_Sdtc_cItem_Att34 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att35") )
            {
               gxTv_Sdtc_cItem_Att35 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att36") )
            {
               gxTv_Sdtc_cItem_Att36 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att37") )
            {
               gxTv_Sdtc_cItem_Att37 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att38") )
            {
               gxTv_Sdtc_cItem_Att38 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att39") )
            {
               gxTv_Sdtc_cItem_Att39 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att40") )
            {
               gxTv_Sdtc_cItem_Att40 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att41") )
            {
               gxTv_Sdtc_cItem_Att41 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att42") )
            {
               gxTv_Sdtc_cItem_Att42 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att43") )
            {
               gxTv_Sdtc_cItem_Att43 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att44") )
            {
               gxTv_Sdtc_cItem_Att44 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att45") )
            {
               gxTv_Sdtc_cItem_Att45 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att46") )
            {
               gxTv_Sdtc_cItem_Att46 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att47") )
            {
               gxTv_Sdtc_cItem_Att47 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att48") )
            {
               gxTv_Sdtc_cItem_Att48 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att49") )
            {
               gxTv_Sdtc_cItem_Att49 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att50") )
            {
               gxTv_Sdtc_cItem_Att50 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att51") )
            {
               gxTv_Sdtc_cItem_Att51 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att52") )
            {
               gxTv_Sdtc_cItem_Att52 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att53") )
            {
               gxTv_Sdtc_cItem_Att53 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att54") )
            {
               gxTv_Sdtc_cItem_Att54 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att55") )
            {
               gxTv_Sdtc_cItem_Att55 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att56") )
            {
               gxTv_Sdtc_cItem_Att56 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att57") )
            {
               gxTv_Sdtc_cItem_Att57 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att58") )
            {
               gxTv_Sdtc_cItem_Att58 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att59") )
            {
               gxTv_Sdtc_cItem_Att59 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att60") )
            {
               gxTv_Sdtc_cItem_Att60 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att61") )
            {
               gxTv_Sdtc_cItem_Att61 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att62") )
            {
               gxTv_Sdtc_cItem_Att62 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att63") )
            {
               gxTv_Sdtc_cItem_Att63 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att64") )
            {
               gxTv_Sdtc_cItem_Att64 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att65") )
            {
               gxTv_Sdtc_cItem_Att65 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att66") )
            {
               gxTv_Sdtc_cItem_Att66 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att67") )
            {
               gxTv_Sdtc_cItem_Att67 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att68") )
            {
               gxTv_Sdtc_cItem_Att68 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att69") )
            {
               gxTv_Sdtc_cItem_Att69 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att70") )
            {
               gxTv_Sdtc_cItem_Att70 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att71") )
            {
               gxTv_Sdtc_cItem_Att71 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att72") )
            {
               gxTv_Sdtc_cItem_Att72 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att73") )
            {
               gxTv_Sdtc_cItem_Att73 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att74") )
            {
               gxTv_Sdtc_cItem_Att74 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att75") )
            {
               gxTv_Sdtc_cItem_Att75 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att76") )
            {
               gxTv_Sdtc_cItem_Att76 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att77") )
            {
               gxTv_Sdtc_cItem_Att77 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att78") )
            {
               gxTv_Sdtc_cItem_Att78 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att79") )
            {
               gxTv_Sdtc_cItem_Att79 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att80") )
            {
               gxTv_Sdtc_cItem_Att80 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att81") )
            {
               gxTv_Sdtc_cItem_Att81 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att82") )
            {
               gxTv_Sdtc_cItem_Att82 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Att83") )
            {
               gxTv_Sdtc_cItem_Att83 = oReader.getValue() ;
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
         sName = "c.cItem" ;
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
      oWriter.writeElement("Att1", gxTv_Sdtc_cItem_Att1);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att2", gxTv_Sdtc_cItem_Att2);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att3", gxTv_Sdtc_cItem_Att3);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att4", gxTv_Sdtc_cItem_Att4);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att5", gxTv_Sdtc_cItem_Att5);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att6", gxTv_Sdtc_cItem_Att6);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att7", gxTv_Sdtc_cItem_Att7);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att8", gxTv_Sdtc_cItem_Att8);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att9", gxTv_Sdtc_cItem_Att9);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att10", gxTv_Sdtc_cItem_Att10);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att11", gxTv_Sdtc_cItem_Att11);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att12", gxTv_Sdtc_cItem_Att12);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att13", gxTv_Sdtc_cItem_Att13);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att14", gxTv_Sdtc_cItem_Att14);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att15", gxTv_Sdtc_cItem_Att15);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att16", gxTv_Sdtc_cItem_Att16);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att17", gxTv_Sdtc_cItem_Att17);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att18", gxTv_Sdtc_cItem_Att18);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att19", gxTv_Sdtc_cItem_Att19);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att20", gxTv_Sdtc_cItem_Att20);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att21", gxTv_Sdtc_cItem_Att21);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att22", gxTv_Sdtc_cItem_Att22);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att23", gxTv_Sdtc_cItem_Att23);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att24", gxTv_Sdtc_cItem_Att24);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att25", gxTv_Sdtc_cItem_Att25);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att26", gxTv_Sdtc_cItem_Att26);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att27", gxTv_Sdtc_cItem_Att27);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att28", gxTv_Sdtc_cItem_Att28);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att29", gxTv_Sdtc_cItem_Att29);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att30", gxTv_Sdtc_cItem_Att30);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att31", gxTv_Sdtc_cItem_Att31);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att32", gxTv_Sdtc_cItem_Att32);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att33", gxTv_Sdtc_cItem_Att33);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att34", gxTv_Sdtc_cItem_Att34);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att35", gxTv_Sdtc_cItem_Att35);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att36", gxTv_Sdtc_cItem_Att36);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att37", gxTv_Sdtc_cItem_Att37);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att38", gxTv_Sdtc_cItem_Att38);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att39", gxTv_Sdtc_cItem_Att39);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att40", gxTv_Sdtc_cItem_Att40);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att41", gxTv_Sdtc_cItem_Att41);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att42", gxTv_Sdtc_cItem_Att42);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att43", gxTv_Sdtc_cItem_Att43);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att44", gxTv_Sdtc_cItem_Att44);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att45", gxTv_Sdtc_cItem_Att45);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att46", gxTv_Sdtc_cItem_Att46);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att47", gxTv_Sdtc_cItem_Att47);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att48", gxTv_Sdtc_cItem_Att48);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att49", gxTv_Sdtc_cItem_Att49);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att50", gxTv_Sdtc_cItem_Att50);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att51", gxTv_Sdtc_cItem_Att51);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att52", gxTv_Sdtc_cItem_Att52);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att53", gxTv_Sdtc_cItem_Att53);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att54", gxTv_Sdtc_cItem_Att54);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att55", gxTv_Sdtc_cItem_Att55);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att56", gxTv_Sdtc_cItem_Att56);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att57", gxTv_Sdtc_cItem_Att57);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att58", gxTv_Sdtc_cItem_Att58);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att59", gxTv_Sdtc_cItem_Att59);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att60", gxTv_Sdtc_cItem_Att60);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att61", gxTv_Sdtc_cItem_Att61);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att62", gxTv_Sdtc_cItem_Att62);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att63", gxTv_Sdtc_cItem_Att63);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att64", gxTv_Sdtc_cItem_Att64);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att65", gxTv_Sdtc_cItem_Att65);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att66", gxTv_Sdtc_cItem_Att66);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att67", gxTv_Sdtc_cItem_Att67);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att68", gxTv_Sdtc_cItem_Att68);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att69", gxTv_Sdtc_cItem_Att69);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att70", gxTv_Sdtc_cItem_Att70);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att71", gxTv_Sdtc_cItem_Att71);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att72", gxTv_Sdtc_cItem_Att72);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att73", gxTv_Sdtc_cItem_Att73);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att74", gxTv_Sdtc_cItem_Att74);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att75", gxTv_Sdtc_cItem_Att75);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att76", gxTv_Sdtc_cItem_Att76);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att77", gxTv_Sdtc_cItem_Att77);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att78", gxTv_Sdtc_cItem_Att78);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att79", gxTv_Sdtc_cItem_Att79);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att80", gxTv_Sdtc_cItem_Att80);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att81", gxTv_Sdtc_cItem_Att81);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att82", gxTv_Sdtc_cItem_Att82);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("Att83", gxTv_Sdtc_cItem_Att83);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
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
      AddObjectProperty("Att1", gxTv_Sdtc_cItem_Att1, false, false);
      AddObjectProperty("Att2", gxTv_Sdtc_cItem_Att2, false, false);
      AddObjectProperty("Att3", gxTv_Sdtc_cItem_Att3, false, false);
      AddObjectProperty("Att4", gxTv_Sdtc_cItem_Att4, false, false);
      AddObjectProperty("Att5", gxTv_Sdtc_cItem_Att5, false, false);
      AddObjectProperty("Att6", gxTv_Sdtc_cItem_Att6, false, false);
      AddObjectProperty("Att7", gxTv_Sdtc_cItem_Att7, false, false);
      AddObjectProperty("Att8", gxTv_Sdtc_cItem_Att8, false, false);
      AddObjectProperty("Att9", gxTv_Sdtc_cItem_Att9, false, false);
      AddObjectProperty("Att10", gxTv_Sdtc_cItem_Att10, false, false);
      AddObjectProperty("Att11", gxTv_Sdtc_cItem_Att11, false, false);
      AddObjectProperty("Att12", gxTv_Sdtc_cItem_Att12, false, false);
      AddObjectProperty("Att13", gxTv_Sdtc_cItem_Att13, false, false);
      AddObjectProperty("Att14", gxTv_Sdtc_cItem_Att14, false, false);
      AddObjectProperty("Att15", gxTv_Sdtc_cItem_Att15, false, false);
      AddObjectProperty("Att16", gxTv_Sdtc_cItem_Att16, false, false);
      AddObjectProperty("Att17", gxTv_Sdtc_cItem_Att17, false, false);
      AddObjectProperty("Att18", gxTv_Sdtc_cItem_Att18, false, false);
      AddObjectProperty("Att19", gxTv_Sdtc_cItem_Att19, false, false);
      AddObjectProperty("Att20", gxTv_Sdtc_cItem_Att20, false, false);
      AddObjectProperty("Att21", gxTv_Sdtc_cItem_Att21, false, false);
      AddObjectProperty("Att22", gxTv_Sdtc_cItem_Att22, false, false);
      AddObjectProperty("Att23", gxTv_Sdtc_cItem_Att23, false, false);
      AddObjectProperty("Att24", gxTv_Sdtc_cItem_Att24, false, false);
      AddObjectProperty("Att25", gxTv_Sdtc_cItem_Att25, false, false);
      AddObjectProperty("Att26", gxTv_Sdtc_cItem_Att26, false, false);
      AddObjectProperty("Att27", gxTv_Sdtc_cItem_Att27, false, false);
      AddObjectProperty("Att28", gxTv_Sdtc_cItem_Att28, false, false);
      AddObjectProperty("Att29", gxTv_Sdtc_cItem_Att29, false, false);
      AddObjectProperty("Att30", gxTv_Sdtc_cItem_Att30, false, false);
      AddObjectProperty("Att31", gxTv_Sdtc_cItem_Att31, false, false);
      AddObjectProperty("Att32", gxTv_Sdtc_cItem_Att32, false, false);
      AddObjectProperty("Att33", gxTv_Sdtc_cItem_Att33, false, false);
      AddObjectProperty("Att34", gxTv_Sdtc_cItem_Att34, false, false);
      AddObjectProperty("Att35", gxTv_Sdtc_cItem_Att35, false, false);
      AddObjectProperty("Att36", gxTv_Sdtc_cItem_Att36, false, false);
      AddObjectProperty("Att37", gxTv_Sdtc_cItem_Att37, false, false);
      AddObjectProperty("Att38", gxTv_Sdtc_cItem_Att38, false, false);
      AddObjectProperty("Att39", gxTv_Sdtc_cItem_Att39, false, false);
      AddObjectProperty("Att40", gxTv_Sdtc_cItem_Att40, false, false);
      AddObjectProperty("Att41", gxTv_Sdtc_cItem_Att41, false, false);
      AddObjectProperty("Att42", gxTv_Sdtc_cItem_Att42, false, false);
      AddObjectProperty("Att43", gxTv_Sdtc_cItem_Att43, false, false);
      AddObjectProperty("Att44", gxTv_Sdtc_cItem_Att44, false, false);
      AddObjectProperty("Att45", gxTv_Sdtc_cItem_Att45, false, false);
      AddObjectProperty("Att46", gxTv_Sdtc_cItem_Att46, false, false);
      AddObjectProperty("Att47", gxTv_Sdtc_cItem_Att47, false, false);
      AddObjectProperty("Att48", gxTv_Sdtc_cItem_Att48, false, false);
      AddObjectProperty("Att49", gxTv_Sdtc_cItem_Att49, false, false);
      AddObjectProperty("Att50", gxTv_Sdtc_cItem_Att50, false, false);
      AddObjectProperty("Att51", gxTv_Sdtc_cItem_Att51, false, false);
      AddObjectProperty("Att52", gxTv_Sdtc_cItem_Att52, false, false);
      AddObjectProperty("Att53", gxTv_Sdtc_cItem_Att53, false, false);
      AddObjectProperty("Att54", gxTv_Sdtc_cItem_Att54, false, false);
      AddObjectProperty("Att55", gxTv_Sdtc_cItem_Att55, false, false);
      AddObjectProperty("Att56", gxTv_Sdtc_cItem_Att56, false, false);
      AddObjectProperty("Att57", gxTv_Sdtc_cItem_Att57, false, false);
      AddObjectProperty("Att58", gxTv_Sdtc_cItem_Att58, false, false);
      AddObjectProperty("Att59", gxTv_Sdtc_cItem_Att59, false, false);
      AddObjectProperty("Att60", gxTv_Sdtc_cItem_Att60, false, false);
      AddObjectProperty("Att61", gxTv_Sdtc_cItem_Att61, false, false);
      AddObjectProperty("Att62", gxTv_Sdtc_cItem_Att62, false, false);
      AddObjectProperty("Att63", gxTv_Sdtc_cItem_Att63, false, false);
      AddObjectProperty("Att64", gxTv_Sdtc_cItem_Att64, false, false);
      AddObjectProperty("Att65", gxTv_Sdtc_cItem_Att65, false, false);
      AddObjectProperty("Att66", gxTv_Sdtc_cItem_Att66, false, false);
      AddObjectProperty("Att67", gxTv_Sdtc_cItem_Att67, false, false);
      AddObjectProperty("Att68", gxTv_Sdtc_cItem_Att68, false, false);
      AddObjectProperty("Att69", gxTv_Sdtc_cItem_Att69, false, false);
      AddObjectProperty("Att70", gxTv_Sdtc_cItem_Att70, false, false);
      AddObjectProperty("Att71", gxTv_Sdtc_cItem_Att71, false, false);
      AddObjectProperty("Att72", gxTv_Sdtc_cItem_Att72, false, false);
      AddObjectProperty("Att73", gxTv_Sdtc_cItem_Att73, false, false);
      AddObjectProperty("Att74", gxTv_Sdtc_cItem_Att74, false, false);
      AddObjectProperty("Att75", gxTv_Sdtc_cItem_Att75, false, false);
      AddObjectProperty("Att76", gxTv_Sdtc_cItem_Att76, false, false);
      AddObjectProperty("Att77", gxTv_Sdtc_cItem_Att77, false, false);
      AddObjectProperty("Att78", gxTv_Sdtc_cItem_Att78, false, false);
      AddObjectProperty("Att79", gxTv_Sdtc_cItem_Att79, false, false);
      AddObjectProperty("Att80", gxTv_Sdtc_cItem_Att80, false, false);
      AddObjectProperty("Att81", gxTv_Sdtc_cItem_Att81, false, false);
      AddObjectProperty("Att82", gxTv_Sdtc_cItem_Att82, false, false);
      AddObjectProperty("Att83", gxTv_Sdtc_cItem_Att83, false, false);
   }

   public String getgxTv_Sdtc_cItem_Att1( )
   {
      return gxTv_Sdtc_cItem_Att1 ;
   }

   public void setgxTv_Sdtc_cItem_Att1( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att1 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att2( )
   {
      return gxTv_Sdtc_cItem_Att2 ;
   }

   public void setgxTv_Sdtc_cItem_Att2( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att2 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att3( )
   {
      return gxTv_Sdtc_cItem_Att3 ;
   }

   public void setgxTv_Sdtc_cItem_Att3( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att3 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att4( )
   {
      return gxTv_Sdtc_cItem_Att4 ;
   }

   public void setgxTv_Sdtc_cItem_Att4( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att4 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att5( )
   {
      return gxTv_Sdtc_cItem_Att5 ;
   }

   public void setgxTv_Sdtc_cItem_Att5( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att5 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att6( )
   {
      return gxTv_Sdtc_cItem_Att6 ;
   }

   public void setgxTv_Sdtc_cItem_Att6( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att6 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att7( )
   {
      return gxTv_Sdtc_cItem_Att7 ;
   }

   public void setgxTv_Sdtc_cItem_Att7( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att7 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att8( )
   {
      return gxTv_Sdtc_cItem_Att8 ;
   }

   public void setgxTv_Sdtc_cItem_Att8( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att8 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att9( )
   {
      return gxTv_Sdtc_cItem_Att9 ;
   }

   public void setgxTv_Sdtc_cItem_Att9( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att9 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att10( )
   {
      return gxTv_Sdtc_cItem_Att10 ;
   }

   public void setgxTv_Sdtc_cItem_Att10( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att10 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att11( )
   {
      return gxTv_Sdtc_cItem_Att11 ;
   }

   public void setgxTv_Sdtc_cItem_Att11( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att11 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att12( )
   {
      return gxTv_Sdtc_cItem_Att12 ;
   }

   public void setgxTv_Sdtc_cItem_Att12( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att12 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att13( )
   {
      return gxTv_Sdtc_cItem_Att13 ;
   }

   public void setgxTv_Sdtc_cItem_Att13( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att13 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att14( )
   {
      return gxTv_Sdtc_cItem_Att14 ;
   }

   public void setgxTv_Sdtc_cItem_Att14( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att14 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att15( )
   {
      return gxTv_Sdtc_cItem_Att15 ;
   }

   public void setgxTv_Sdtc_cItem_Att15( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att15 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att16( )
   {
      return gxTv_Sdtc_cItem_Att16 ;
   }

   public void setgxTv_Sdtc_cItem_Att16( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att16 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att17( )
   {
      return gxTv_Sdtc_cItem_Att17 ;
   }

   public void setgxTv_Sdtc_cItem_Att17( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att17 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att18( )
   {
      return gxTv_Sdtc_cItem_Att18 ;
   }

   public void setgxTv_Sdtc_cItem_Att18( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att18 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att19( )
   {
      return gxTv_Sdtc_cItem_Att19 ;
   }

   public void setgxTv_Sdtc_cItem_Att19( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att19 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att20( )
   {
      return gxTv_Sdtc_cItem_Att20 ;
   }

   public void setgxTv_Sdtc_cItem_Att20( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att20 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att21( )
   {
      return gxTv_Sdtc_cItem_Att21 ;
   }

   public void setgxTv_Sdtc_cItem_Att21( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att21 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att22( )
   {
      return gxTv_Sdtc_cItem_Att22 ;
   }

   public void setgxTv_Sdtc_cItem_Att22( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att22 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att23( )
   {
      return gxTv_Sdtc_cItem_Att23 ;
   }

   public void setgxTv_Sdtc_cItem_Att23( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att23 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att24( )
   {
      return gxTv_Sdtc_cItem_Att24 ;
   }

   public void setgxTv_Sdtc_cItem_Att24( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att24 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att25( )
   {
      return gxTv_Sdtc_cItem_Att25 ;
   }

   public void setgxTv_Sdtc_cItem_Att25( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att25 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att26( )
   {
      return gxTv_Sdtc_cItem_Att26 ;
   }

   public void setgxTv_Sdtc_cItem_Att26( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att26 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att27( )
   {
      return gxTv_Sdtc_cItem_Att27 ;
   }

   public void setgxTv_Sdtc_cItem_Att27( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att27 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att28( )
   {
      return gxTv_Sdtc_cItem_Att28 ;
   }

   public void setgxTv_Sdtc_cItem_Att28( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att28 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att29( )
   {
      return gxTv_Sdtc_cItem_Att29 ;
   }

   public void setgxTv_Sdtc_cItem_Att29( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att29 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att30( )
   {
      return gxTv_Sdtc_cItem_Att30 ;
   }

   public void setgxTv_Sdtc_cItem_Att30( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att30 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att31( )
   {
      return gxTv_Sdtc_cItem_Att31 ;
   }

   public void setgxTv_Sdtc_cItem_Att31( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att31 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att32( )
   {
      return gxTv_Sdtc_cItem_Att32 ;
   }

   public void setgxTv_Sdtc_cItem_Att32( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att32 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att33( )
   {
      return gxTv_Sdtc_cItem_Att33 ;
   }

   public void setgxTv_Sdtc_cItem_Att33( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att33 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att34( )
   {
      return gxTv_Sdtc_cItem_Att34 ;
   }

   public void setgxTv_Sdtc_cItem_Att34( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att34 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att35( )
   {
      return gxTv_Sdtc_cItem_Att35 ;
   }

   public void setgxTv_Sdtc_cItem_Att35( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att35 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att36( )
   {
      return gxTv_Sdtc_cItem_Att36 ;
   }

   public void setgxTv_Sdtc_cItem_Att36( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att36 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att37( )
   {
      return gxTv_Sdtc_cItem_Att37 ;
   }

   public void setgxTv_Sdtc_cItem_Att37( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att37 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att38( )
   {
      return gxTv_Sdtc_cItem_Att38 ;
   }

   public void setgxTv_Sdtc_cItem_Att38( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att38 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att39( )
   {
      return gxTv_Sdtc_cItem_Att39 ;
   }

   public void setgxTv_Sdtc_cItem_Att39( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att39 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att40( )
   {
      return gxTv_Sdtc_cItem_Att40 ;
   }

   public void setgxTv_Sdtc_cItem_Att40( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att40 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att41( )
   {
      return gxTv_Sdtc_cItem_Att41 ;
   }

   public void setgxTv_Sdtc_cItem_Att41( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att41 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att42( )
   {
      return gxTv_Sdtc_cItem_Att42 ;
   }

   public void setgxTv_Sdtc_cItem_Att42( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att42 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att43( )
   {
      return gxTv_Sdtc_cItem_Att43 ;
   }

   public void setgxTv_Sdtc_cItem_Att43( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att43 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att44( )
   {
      return gxTv_Sdtc_cItem_Att44 ;
   }

   public void setgxTv_Sdtc_cItem_Att44( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att44 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att45( )
   {
      return gxTv_Sdtc_cItem_Att45 ;
   }

   public void setgxTv_Sdtc_cItem_Att45( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att45 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att46( )
   {
      return gxTv_Sdtc_cItem_Att46 ;
   }

   public void setgxTv_Sdtc_cItem_Att46( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att46 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att47( )
   {
      return gxTv_Sdtc_cItem_Att47 ;
   }

   public void setgxTv_Sdtc_cItem_Att47( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att47 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att48( )
   {
      return gxTv_Sdtc_cItem_Att48 ;
   }

   public void setgxTv_Sdtc_cItem_Att48( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att48 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att49( )
   {
      return gxTv_Sdtc_cItem_Att49 ;
   }

   public void setgxTv_Sdtc_cItem_Att49( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att49 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att50( )
   {
      return gxTv_Sdtc_cItem_Att50 ;
   }

   public void setgxTv_Sdtc_cItem_Att50( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att50 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att51( )
   {
      return gxTv_Sdtc_cItem_Att51 ;
   }

   public void setgxTv_Sdtc_cItem_Att51( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att51 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att52( )
   {
      return gxTv_Sdtc_cItem_Att52 ;
   }

   public void setgxTv_Sdtc_cItem_Att52( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att52 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att53( )
   {
      return gxTv_Sdtc_cItem_Att53 ;
   }

   public void setgxTv_Sdtc_cItem_Att53( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att53 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att54( )
   {
      return gxTv_Sdtc_cItem_Att54 ;
   }

   public void setgxTv_Sdtc_cItem_Att54( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att54 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att55( )
   {
      return gxTv_Sdtc_cItem_Att55 ;
   }

   public void setgxTv_Sdtc_cItem_Att55( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att55 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att56( )
   {
      return gxTv_Sdtc_cItem_Att56 ;
   }

   public void setgxTv_Sdtc_cItem_Att56( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att56 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att57( )
   {
      return gxTv_Sdtc_cItem_Att57 ;
   }

   public void setgxTv_Sdtc_cItem_Att57( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att57 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att58( )
   {
      return gxTv_Sdtc_cItem_Att58 ;
   }

   public void setgxTv_Sdtc_cItem_Att58( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att58 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att59( )
   {
      return gxTv_Sdtc_cItem_Att59 ;
   }

   public void setgxTv_Sdtc_cItem_Att59( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att59 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att60( )
   {
      return gxTv_Sdtc_cItem_Att60 ;
   }

   public void setgxTv_Sdtc_cItem_Att60( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att60 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att61( )
   {
      return gxTv_Sdtc_cItem_Att61 ;
   }

   public void setgxTv_Sdtc_cItem_Att61( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att61 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att62( )
   {
      return gxTv_Sdtc_cItem_Att62 ;
   }

   public void setgxTv_Sdtc_cItem_Att62( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att62 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att63( )
   {
      return gxTv_Sdtc_cItem_Att63 ;
   }

   public void setgxTv_Sdtc_cItem_Att63( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att63 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att64( )
   {
      return gxTv_Sdtc_cItem_Att64 ;
   }

   public void setgxTv_Sdtc_cItem_Att64( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att64 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att65( )
   {
      return gxTv_Sdtc_cItem_Att65 ;
   }

   public void setgxTv_Sdtc_cItem_Att65( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att65 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att66( )
   {
      return gxTv_Sdtc_cItem_Att66 ;
   }

   public void setgxTv_Sdtc_cItem_Att66( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att66 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att67( )
   {
      return gxTv_Sdtc_cItem_Att67 ;
   }

   public void setgxTv_Sdtc_cItem_Att67( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att67 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att68( )
   {
      return gxTv_Sdtc_cItem_Att68 ;
   }

   public void setgxTv_Sdtc_cItem_Att68( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att68 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att69( )
   {
      return gxTv_Sdtc_cItem_Att69 ;
   }

   public void setgxTv_Sdtc_cItem_Att69( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att69 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att70( )
   {
      return gxTv_Sdtc_cItem_Att70 ;
   }

   public void setgxTv_Sdtc_cItem_Att70( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att70 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att71( )
   {
      return gxTv_Sdtc_cItem_Att71 ;
   }

   public void setgxTv_Sdtc_cItem_Att71( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att71 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att72( )
   {
      return gxTv_Sdtc_cItem_Att72 ;
   }

   public void setgxTv_Sdtc_cItem_Att72( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att72 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att73( )
   {
      return gxTv_Sdtc_cItem_Att73 ;
   }

   public void setgxTv_Sdtc_cItem_Att73( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att73 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att74( )
   {
      return gxTv_Sdtc_cItem_Att74 ;
   }

   public void setgxTv_Sdtc_cItem_Att74( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att74 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att75( )
   {
      return gxTv_Sdtc_cItem_Att75 ;
   }

   public void setgxTv_Sdtc_cItem_Att75( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att75 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att76( )
   {
      return gxTv_Sdtc_cItem_Att76 ;
   }

   public void setgxTv_Sdtc_cItem_Att76( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att76 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att77( )
   {
      return gxTv_Sdtc_cItem_Att77 ;
   }

   public void setgxTv_Sdtc_cItem_Att77( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att77 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att78( )
   {
      return gxTv_Sdtc_cItem_Att78 ;
   }

   public void setgxTv_Sdtc_cItem_Att78( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att78 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att79( )
   {
      return gxTv_Sdtc_cItem_Att79 ;
   }

   public void setgxTv_Sdtc_cItem_Att79( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att79 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att80( )
   {
      return gxTv_Sdtc_cItem_Att80 ;
   }

   public void setgxTv_Sdtc_cItem_Att80( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att80 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att81( )
   {
      return gxTv_Sdtc_cItem_Att81 ;
   }

   public void setgxTv_Sdtc_cItem_Att81( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att81 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att82( )
   {
      return gxTv_Sdtc_cItem_Att82 ;
   }

   public void setgxTv_Sdtc_cItem_Att82( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att82 = value ;
   }

   public String getgxTv_Sdtc_cItem_Att83( )
   {
      return gxTv_Sdtc_cItem_Att83 ;
   }

   public void setgxTv_Sdtc_cItem_Att83( String value )
   {
      gxTv_Sdtc_cItem_N = (byte)(0) ;
      gxTv_Sdtc_cItem_Att83 = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtc_cItem_Att1 = "" ;
      gxTv_Sdtc_cItem_N = (byte)(1) ;
      gxTv_Sdtc_cItem_Att2 = "" ;
      gxTv_Sdtc_cItem_Att3 = "" ;
      gxTv_Sdtc_cItem_Att4 = "" ;
      gxTv_Sdtc_cItem_Att5 = "" ;
      gxTv_Sdtc_cItem_Att6 = "" ;
      gxTv_Sdtc_cItem_Att7 = "" ;
      gxTv_Sdtc_cItem_Att8 = "" ;
      gxTv_Sdtc_cItem_Att9 = "" ;
      gxTv_Sdtc_cItem_Att10 = "" ;
      gxTv_Sdtc_cItem_Att11 = "" ;
      gxTv_Sdtc_cItem_Att12 = "" ;
      gxTv_Sdtc_cItem_Att13 = "" ;
      gxTv_Sdtc_cItem_Att14 = "" ;
      gxTv_Sdtc_cItem_Att15 = "" ;
      gxTv_Sdtc_cItem_Att16 = "" ;
      gxTv_Sdtc_cItem_Att17 = "" ;
      gxTv_Sdtc_cItem_Att18 = "" ;
      gxTv_Sdtc_cItem_Att19 = "" ;
      gxTv_Sdtc_cItem_Att20 = "" ;
      gxTv_Sdtc_cItem_Att21 = "" ;
      gxTv_Sdtc_cItem_Att22 = "" ;
      gxTv_Sdtc_cItem_Att23 = "" ;
      gxTv_Sdtc_cItem_Att24 = "" ;
      gxTv_Sdtc_cItem_Att25 = "" ;
      gxTv_Sdtc_cItem_Att26 = "" ;
      gxTv_Sdtc_cItem_Att27 = "" ;
      gxTv_Sdtc_cItem_Att28 = "" ;
      gxTv_Sdtc_cItem_Att29 = "" ;
      gxTv_Sdtc_cItem_Att30 = "" ;
      gxTv_Sdtc_cItem_Att31 = "" ;
      gxTv_Sdtc_cItem_Att32 = "" ;
      gxTv_Sdtc_cItem_Att33 = "" ;
      gxTv_Sdtc_cItem_Att34 = "" ;
      gxTv_Sdtc_cItem_Att35 = "" ;
      gxTv_Sdtc_cItem_Att36 = "" ;
      gxTv_Sdtc_cItem_Att37 = "" ;
      gxTv_Sdtc_cItem_Att38 = "" ;
      gxTv_Sdtc_cItem_Att39 = "" ;
      gxTv_Sdtc_cItem_Att40 = "" ;
      gxTv_Sdtc_cItem_Att41 = "" ;
      gxTv_Sdtc_cItem_Att42 = "" ;
      gxTv_Sdtc_cItem_Att43 = "" ;
      gxTv_Sdtc_cItem_Att44 = "" ;
      gxTv_Sdtc_cItem_Att45 = "" ;
      gxTv_Sdtc_cItem_Att46 = "" ;
      gxTv_Sdtc_cItem_Att47 = "" ;
      gxTv_Sdtc_cItem_Att48 = "" ;
      gxTv_Sdtc_cItem_Att49 = "" ;
      gxTv_Sdtc_cItem_Att50 = "" ;
      gxTv_Sdtc_cItem_Att51 = "" ;
      gxTv_Sdtc_cItem_Att52 = "" ;
      gxTv_Sdtc_cItem_Att53 = "" ;
      gxTv_Sdtc_cItem_Att54 = "" ;
      gxTv_Sdtc_cItem_Att55 = "" ;
      gxTv_Sdtc_cItem_Att56 = "" ;
      gxTv_Sdtc_cItem_Att57 = "" ;
      gxTv_Sdtc_cItem_Att58 = "" ;
      gxTv_Sdtc_cItem_Att59 = "" ;
      gxTv_Sdtc_cItem_Att60 = "" ;
      gxTv_Sdtc_cItem_Att61 = "" ;
      gxTv_Sdtc_cItem_Att62 = "" ;
      gxTv_Sdtc_cItem_Att63 = "" ;
      gxTv_Sdtc_cItem_Att64 = "" ;
      gxTv_Sdtc_cItem_Att65 = "" ;
      gxTv_Sdtc_cItem_Att66 = "" ;
      gxTv_Sdtc_cItem_Att67 = "" ;
      gxTv_Sdtc_cItem_Att68 = "" ;
      gxTv_Sdtc_cItem_Att69 = "" ;
      gxTv_Sdtc_cItem_Att70 = "" ;
      gxTv_Sdtc_cItem_Att71 = "" ;
      gxTv_Sdtc_cItem_Att72 = "" ;
      gxTv_Sdtc_cItem_Att73 = "" ;
      gxTv_Sdtc_cItem_Att74 = "" ;
      gxTv_Sdtc_cItem_Att75 = "" ;
      gxTv_Sdtc_cItem_Att76 = "" ;
      gxTv_Sdtc_cItem_Att77 = "" ;
      gxTv_Sdtc_cItem_Att78 = "" ;
      gxTv_Sdtc_cItem_Att79 = "" ;
      gxTv_Sdtc_cItem_Att80 = "" ;
      gxTv_Sdtc_cItem_Att81 = "" ;
      gxTv_Sdtc_cItem_Att82 = "" ;
      gxTv_Sdtc_cItem_Att83 = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtc_cItem_N ;
   }

   public web.Sdtc_cItem Clone( )
   {
      return (web.Sdtc_cItem)(clone()) ;
   }

   public void setStruct( web.StructSdtc_cItem struct )
   {
      setgxTv_Sdtc_cItem_Att1(struct.getAtt1());
      setgxTv_Sdtc_cItem_Att2(struct.getAtt2());
      setgxTv_Sdtc_cItem_Att3(struct.getAtt3());
      setgxTv_Sdtc_cItem_Att4(struct.getAtt4());
      setgxTv_Sdtc_cItem_Att5(struct.getAtt5());
      setgxTv_Sdtc_cItem_Att6(struct.getAtt6());
      setgxTv_Sdtc_cItem_Att7(struct.getAtt7());
      setgxTv_Sdtc_cItem_Att8(struct.getAtt8());
      setgxTv_Sdtc_cItem_Att9(struct.getAtt9());
      setgxTv_Sdtc_cItem_Att10(struct.getAtt10());
      setgxTv_Sdtc_cItem_Att11(struct.getAtt11());
      setgxTv_Sdtc_cItem_Att12(struct.getAtt12());
      setgxTv_Sdtc_cItem_Att13(struct.getAtt13());
      setgxTv_Sdtc_cItem_Att14(struct.getAtt14());
      setgxTv_Sdtc_cItem_Att15(struct.getAtt15());
      setgxTv_Sdtc_cItem_Att16(struct.getAtt16());
      setgxTv_Sdtc_cItem_Att17(struct.getAtt17());
      setgxTv_Sdtc_cItem_Att18(struct.getAtt18());
      setgxTv_Sdtc_cItem_Att19(struct.getAtt19());
      setgxTv_Sdtc_cItem_Att20(struct.getAtt20());
      setgxTv_Sdtc_cItem_Att21(struct.getAtt21());
      setgxTv_Sdtc_cItem_Att22(struct.getAtt22());
      setgxTv_Sdtc_cItem_Att23(struct.getAtt23());
      setgxTv_Sdtc_cItem_Att24(struct.getAtt24());
      setgxTv_Sdtc_cItem_Att25(struct.getAtt25());
      setgxTv_Sdtc_cItem_Att26(struct.getAtt26());
      setgxTv_Sdtc_cItem_Att27(struct.getAtt27());
      setgxTv_Sdtc_cItem_Att28(struct.getAtt28());
      setgxTv_Sdtc_cItem_Att29(struct.getAtt29());
      setgxTv_Sdtc_cItem_Att30(struct.getAtt30());
      setgxTv_Sdtc_cItem_Att31(struct.getAtt31());
      setgxTv_Sdtc_cItem_Att32(struct.getAtt32());
      setgxTv_Sdtc_cItem_Att33(struct.getAtt33());
      setgxTv_Sdtc_cItem_Att34(struct.getAtt34());
      setgxTv_Sdtc_cItem_Att35(struct.getAtt35());
      setgxTv_Sdtc_cItem_Att36(struct.getAtt36());
      setgxTv_Sdtc_cItem_Att37(struct.getAtt37());
      setgxTv_Sdtc_cItem_Att38(struct.getAtt38());
      setgxTv_Sdtc_cItem_Att39(struct.getAtt39());
      setgxTv_Sdtc_cItem_Att40(struct.getAtt40());
      setgxTv_Sdtc_cItem_Att41(struct.getAtt41());
      setgxTv_Sdtc_cItem_Att42(struct.getAtt42());
      setgxTv_Sdtc_cItem_Att43(struct.getAtt43());
      setgxTv_Sdtc_cItem_Att44(struct.getAtt44());
      setgxTv_Sdtc_cItem_Att45(struct.getAtt45());
      setgxTv_Sdtc_cItem_Att46(struct.getAtt46());
      setgxTv_Sdtc_cItem_Att47(struct.getAtt47());
      setgxTv_Sdtc_cItem_Att48(struct.getAtt48());
      setgxTv_Sdtc_cItem_Att49(struct.getAtt49());
      setgxTv_Sdtc_cItem_Att50(struct.getAtt50());
      setgxTv_Sdtc_cItem_Att51(struct.getAtt51());
      setgxTv_Sdtc_cItem_Att52(struct.getAtt52());
      setgxTv_Sdtc_cItem_Att53(struct.getAtt53());
      setgxTv_Sdtc_cItem_Att54(struct.getAtt54());
      setgxTv_Sdtc_cItem_Att55(struct.getAtt55());
      setgxTv_Sdtc_cItem_Att56(struct.getAtt56());
      setgxTv_Sdtc_cItem_Att57(struct.getAtt57());
      setgxTv_Sdtc_cItem_Att58(struct.getAtt58());
      setgxTv_Sdtc_cItem_Att59(struct.getAtt59());
      setgxTv_Sdtc_cItem_Att60(struct.getAtt60());
      setgxTv_Sdtc_cItem_Att61(struct.getAtt61());
      setgxTv_Sdtc_cItem_Att62(struct.getAtt62());
      setgxTv_Sdtc_cItem_Att63(struct.getAtt63());
      setgxTv_Sdtc_cItem_Att64(struct.getAtt64());
      setgxTv_Sdtc_cItem_Att65(struct.getAtt65());
      setgxTv_Sdtc_cItem_Att66(struct.getAtt66());
      setgxTv_Sdtc_cItem_Att67(struct.getAtt67());
      setgxTv_Sdtc_cItem_Att68(struct.getAtt68());
      setgxTv_Sdtc_cItem_Att69(struct.getAtt69());
      setgxTv_Sdtc_cItem_Att70(struct.getAtt70());
      setgxTv_Sdtc_cItem_Att71(struct.getAtt71());
      setgxTv_Sdtc_cItem_Att72(struct.getAtt72());
      setgxTv_Sdtc_cItem_Att73(struct.getAtt73());
      setgxTv_Sdtc_cItem_Att74(struct.getAtt74());
      setgxTv_Sdtc_cItem_Att75(struct.getAtt75());
      setgxTv_Sdtc_cItem_Att76(struct.getAtt76());
      setgxTv_Sdtc_cItem_Att77(struct.getAtt77());
      setgxTv_Sdtc_cItem_Att78(struct.getAtt78());
      setgxTv_Sdtc_cItem_Att79(struct.getAtt79());
      setgxTv_Sdtc_cItem_Att80(struct.getAtt80());
      setgxTv_Sdtc_cItem_Att81(struct.getAtt81());
      setgxTv_Sdtc_cItem_Att82(struct.getAtt82());
      setgxTv_Sdtc_cItem_Att83(struct.getAtt83());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtc_cItem getStruct( )
   {
      web.StructSdtc_cItem struct = new web.StructSdtc_cItem ();
      struct.setAtt1(getgxTv_Sdtc_cItem_Att1());
      struct.setAtt2(getgxTv_Sdtc_cItem_Att2());
      struct.setAtt3(getgxTv_Sdtc_cItem_Att3());
      struct.setAtt4(getgxTv_Sdtc_cItem_Att4());
      struct.setAtt5(getgxTv_Sdtc_cItem_Att5());
      struct.setAtt6(getgxTv_Sdtc_cItem_Att6());
      struct.setAtt7(getgxTv_Sdtc_cItem_Att7());
      struct.setAtt8(getgxTv_Sdtc_cItem_Att8());
      struct.setAtt9(getgxTv_Sdtc_cItem_Att9());
      struct.setAtt10(getgxTv_Sdtc_cItem_Att10());
      struct.setAtt11(getgxTv_Sdtc_cItem_Att11());
      struct.setAtt12(getgxTv_Sdtc_cItem_Att12());
      struct.setAtt13(getgxTv_Sdtc_cItem_Att13());
      struct.setAtt14(getgxTv_Sdtc_cItem_Att14());
      struct.setAtt15(getgxTv_Sdtc_cItem_Att15());
      struct.setAtt16(getgxTv_Sdtc_cItem_Att16());
      struct.setAtt17(getgxTv_Sdtc_cItem_Att17());
      struct.setAtt18(getgxTv_Sdtc_cItem_Att18());
      struct.setAtt19(getgxTv_Sdtc_cItem_Att19());
      struct.setAtt20(getgxTv_Sdtc_cItem_Att20());
      struct.setAtt21(getgxTv_Sdtc_cItem_Att21());
      struct.setAtt22(getgxTv_Sdtc_cItem_Att22());
      struct.setAtt23(getgxTv_Sdtc_cItem_Att23());
      struct.setAtt24(getgxTv_Sdtc_cItem_Att24());
      struct.setAtt25(getgxTv_Sdtc_cItem_Att25());
      struct.setAtt26(getgxTv_Sdtc_cItem_Att26());
      struct.setAtt27(getgxTv_Sdtc_cItem_Att27());
      struct.setAtt28(getgxTv_Sdtc_cItem_Att28());
      struct.setAtt29(getgxTv_Sdtc_cItem_Att29());
      struct.setAtt30(getgxTv_Sdtc_cItem_Att30());
      struct.setAtt31(getgxTv_Sdtc_cItem_Att31());
      struct.setAtt32(getgxTv_Sdtc_cItem_Att32());
      struct.setAtt33(getgxTv_Sdtc_cItem_Att33());
      struct.setAtt34(getgxTv_Sdtc_cItem_Att34());
      struct.setAtt35(getgxTv_Sdtc_cItem_Att35());
      struct.setAtt36(getgxTv_Sdtc_cItem_Att36());
      struct.setAtt37(getgxTv_Sdtc_cItem_Att37());
      struct.setAtt38(getgxTv_Sdtc_cItem_Att38());
      struct.setAtt39(getgxTv_Sdtc_cItem_Att39());
      struct.setAtt40(getgxTv_Sdtc_cItem_Att40());
      struct.setAtt41(getgxTv_Sdtc_cItem_Att41());
      struct.setAtt42(getgxTv_Sdtc_cItem_Att42());
      struct.setAtt43(getgxTv_Sdtc_cItem_Att43());
      struct.setAtt44(getgxTv_Sdtc_cItem_Att44());
      struct.setAtt45(getgxTv_Sdtc_cItem_Att45());
      struct.setAtt46(getgxTv_Sdtc_cItem_Att46());
      struct.setAtt47(getgxTv_Sdtc_cItem_Att47());
      struct.setAtt48(getgxTv_Sdtc_cItem_Att48());
      struct.setAtt49(getgxTv_Sdtc_cItem_Att49());
      struct.setAtt50(getgxTv_Sdtc_cItem_Att50());
      struct.setAtt51(getgxTv_Sdtc_cItem_Att51());
      struct.setAtt52(getgxTv_Sdtc_cItem_Att52());
      struct.setAtt53(getgxTv_Sdtc_cItem_Att53());
      struct.setAtt54(getgxTv_Sdtc_cItem_Att54());
      struct.setAtt55(getgxTv_Sdtc_cItem_Att55());
      struct.setAtt56(getgxTv_Sdtc_cItem_Att56());
      struct.setAtt57(getgxTv_Sdtc_cItem_Att57());
      struct.setAtt58(getgxTv_Sdtc_cItem_Att58());
      struct.setAtt59(getgxTv_Sdtc_cItem_Att59());
      struct.setAtt60(getgxTv_Sdtc_cItem_Att60());
      struct.setAtt61(getgxTv_Sdtc_cItem_Att61());
      struct.setAtt62(getgxTv_Sdtc_cItem_Att62());
      struct.setAtt63(getgxTv_Sdtc_cItem_Att63());
      struct.setAtt64(getgxTv_Sdtc_cItem_Att64());
      struct.setAtt65(getgxTv_Sdtc_cItem_Att65());
      struct.setAtt66(getgxTv_Sdtc_cItem_Att66());
      struct.setAtt67(getgxTv_Sdtc_cItem_Att67());
      struct.setAtt68(getgxTv_Sdtc_cItem_Att68());
      struct.setAtt69(getgxTv_Sdtc_cItem_Att69());
      struct.setAtt70(getgxTv_Sdtc_cItem_Att70());
      struct.setAtt71(getgxTv_Sdtc_cItem_Att71());
      struct.setAtt72(getgxTv_Sdtc_cItem_Att72());
      struct.setAtt73(getgxTv_Sdtc_cItem_Att73());
      struct.setAtt74(getgxTv_Sdtc_cItem_Att74());
      struct.setAtt75(getgxTv_Sdtc_cItem_Att75());
      struct.setAtt76(getgxTv_Sdtc_cItem_Att76());
      struct.setAtt77(getgxTv_Sdtc_cItem_Att77());
      struct.setAtt78(getgxTv_Sdtc_cItem_Att78());
      struct.setAtt79(getgxTv_Sdtc_cItem_Att79());
      struct.setAtt80(getgxTv_Sdtc_cItem_Att80());
      struct.setAtt81(getgxTv_Sdtc_cItem_Att81());
      struct.setAtt82(getgxTv_Sdtc_cItem_Att82());
      struct.setAtt83(getgxTv_Sdtc_cItem_Att83());
      return struct ;
   }

   protected byte gxTv_Sdtc_cItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtc_cItem_Att1 ;
   protected String gxTv_Sdtc_cItem_Att2 ;
   protected String gxTv_Sdtc_cItem_Att3 ;
   protected String gxTv_Sdtc_cItem_Att4 ;
   protected String gxTv_Sdtc_cItem_Att5 ;
   protected String gxTv_Sdtc_cItem_Att6 ;
   protected String gxTv_Sdtc_cItem_Att7 ;
   protected String gxTv_Sdtc_cItem_Att8 ;
   protected String gxTv_Sdtc_cItem_Att9 ;
   protected String gxTv_Sdtc_cItem_Att10 ;
   protected String gxTv_Sdtc_cItem_Att11 ;
   protected String gxTv_Sdtc_cItem_Att12 ;
   protected String gxTv_Sdtc_cItem_Att13 ;
   protected String gxTv_Sdtc_cItem_Att14 ;
   protected String gxTv_Sdtc_cItem_Att15 ;
   protected String gxTv_Sdtc_cItem_Att16 ;
   protected String gxTv_Sdtc_cItem_Att17 ;
   protected String gxTv_Sdtc_cItem_Att18 ;
   protected String gxTv_Sdtc_cItem_Att19 ;
   protected String gxTv_Sdtc_cItem_Att20 ;
   protected String gxTv_Sdtc_cItem_Att21 ;
   protected String gxTv_Sdtc_cItem_Att22 ;
   protected String gxTv_Sdtc_cItem_Att23 ;
   protected String gxTv_Sdtc_cItem_Att24 ;
   protected String gxTv_Sdtc_cItem_Att25 ;
   protected String gxTv_Sdtc_cItem_Att26 ;
   protected String gxTv_Sdtc_cItem_Att27 ;
   protected String gxTv_Sdtc_cItem_Att28 ;
   protected String gxTv_Sdtc_cItem_Att29 ;
   protected String gxTv_Sdtc_cItem_Att30 ;
   protected String gxTv_Sdtc_cItem_Att31 ;
   protected String gxTv_Sdtc_cItem_Att32 ;
   protected String gxTv_Sdtc_cItem_Att33 ;
   protected String gxTv_Sdtc_cItem_Att34 ;
   protected String gxTv_Sdtc_cItem_Att35 ;
   protected String gxTv_Sdtc_cItem_Att36 ;
   protected String gxTv_Sdtc_cItem_Att37 ;
   protected String gxTv_Sdtc_cItem_Att38 ;
   protected String gxTv_Sdtc_cItem_Att39 ;
   protected String gxTv_Sdtc_cItem_Att40 ;
   protected String gxTv_Sdtc_cItem_Att41 ;
   protected String gxTv_Sdtc_cItem_Att42 ;
   protected String gxTv_Sdtc_cItem_Att43 ;
   protected String gxTv_Sdtc_cItem_Att44 ;
   protected String gxTv_Sdtc_cItem_Att45 ;
   protected String gxTv_Sdtc_cItem_Att46 ;
   protected String gxTv_Sdtc_cItem_Att47 ;
   protected String gxTv_Sdtc_cItem_Att48 ;
   protected String gxTv_Sdtc_cItem_Att49 ;
   protected String gxTv_Sdtc_cItem_Att50 ;
   protected String gxTv_Sdtc_cItem_Att51 ;
   protected String gxTv_Sdtc_cItem_Att52 ;
   protected String gxTv_Sdtc_cItem_Att53 ;
   protected String gxTv_Sdtc_cItem_Att54 ;
   protected String gxTv_Sdtc_cItem_Att55 ;
   protected String gxTv_Sdtc_cItem_Att56 ;
   protected String gxTv_Sdtc_cItem_Att57 ;
   protected String gxTv_Sdtc_cItem_Att58 ;
   protected String gxTv_Sdtc_cItem_Att59 ;
   protected String gxTv_Sdtc_cItem_Att60 ;
   protected String gxTv_Sdtc_cItem_Att61 ;
   protected String gxTv_Sdtc_cItem_Att62 ;
   protected String gxTv_Sdtc_cItem_Att63 ;
   protected String gxTv_Sdtc_cItem_Att64 ;
   protected String gxTv_Sdtc_cItem_Att65 ;
   protected String gxTv_Sdtc_cItem_Att66 ;
   protected String gxTv_Sdtc_cItem_Att67 ;
   protected String gxTv_Sdtc_cItem_Att68 ;
   protected String gxTv_Sdtc_cItem_Att69 ;
   protected String gxTv_Sdtc_cItem_Att70 ;
   protected String gxTv_Sdtc_cItem_Att71 ;
   protected String gxTv_Sdtc_cItem_Att72 ;
   protected String gxTv_Sdtc_cItem_Att73 ;
   protected String gxTv_Sdtc_cItem_Att74 ;
   protected String gxTv_Sdtc_cItem_Att75 ;
   protected String gxTv_Sdtc_cItem_Att76 ;
   protected String gxTv_Sdtc_cItem_Att77 ;
   protected String gxTv_Sdtc_cItem_Att78 ;
   protected String gxTv_Sdtc_cItem_Att79 ;
   protected String gxTv_Sdtc_cItem_Att80 ;
   protected String gxTv_Sdtc_cItem_Att81 ;
   protected String gxTv_Sdtc_cItem_Att82 ;
   protected String gxTv_Sdtc_cItem_Att83 ;
}

